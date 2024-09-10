class Account2(private var balance: Double) {
  
  def deposit(amount: Double): Unit = {
    require(amount > 0, "Deposit amount must be positive")
    balance += amount
  }
 
  def withdraw(amount: Double): Unit = {
    require(amount > 0, "Withdrawal amount must be positive")
    require(amount <= balance, "Insufficient funds")
    balance -= amount
  }
 
  def transfer(amount: Double, targetAccount2: Account2): Unit = {
    require(amount > 0, "Transfer amount must be positive")
    require(amount <= balance, "Insufficient funds")
    this.withdraw(amount)
    targetAccount2.deposit(amount)
  }

  def getBalance: Double = balance 
  
  override def toString: String = f"Account2 balance: $$${balance}%.2f"
}

class Bank(private val Account2s: List[Account2]) {
  
  def Account2sWithNegativeBalances: List[Account2] = {
    Account2s.filter(Account2 => Account2.getBalance < 0)
  }
 
  def totalBalance: Double = {
    Account2s.map(_.getBalance).sum
  }
  
  def applyInterest(): Unit = {
    Account2s.foreach { Account2 =>
      val balance = Account2.getBalance
      if (balance > 0) {
        Account2.deposit(balance * 0.05) 
      } else {
        Account2.withdraw(balance * 0.1)  
      }
    }
  }
}

object BankTest extends App {
  val Account21 = new Account2(500.0)
  val Account22 = new Account2(-150.0)
  val Account23 = new Account2(300.0)
  val Account24 = new Account2(-50.0)

  val bank = new Bank(List(Account21, Account22, Account23, Account24))

  
  println("Account2s with negative balances:")
  bank.Account2sWithNegativeBalances.foreach(println)

  
  println(s"Total balance: $$${bank.totalBalance}")

 
  bank.applyInterest()
  println("Final Account2 balances after interest:")
  bank.Account2sWithNegativeBalances.foreach(println)  
}