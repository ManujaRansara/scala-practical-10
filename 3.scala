class Account(private var balance: Double) {
  
  def deposit(amount: Double): Unit = {
    require(amount > 0, "Deposit amount must be positive")
    balance += amount
    println(s"Deposited: $$${amount}. New balance: $$${balance}")
  } 
  
  def withdraw(amount: Double): Unit = {
    require(amount > 0, "Withdrawal amount must be positive")
    require(amount <= balance, "Insufficient funds")
    balance -= amount
    println(s"Withdrew: $$${amount}. New balance: $$${balance}")
  }
  
  def transfer(amount: Double, targetAccount: Account): Unit = {
    require(amount > 0, "Transfer amount must be positive")
    require(amount <= balance, "Insufficient funds")
    this.withdraw(amount)
    targetAccount.deposit(amount)
    println(s"Transferred: $$${amount} to target account. New balance: $$${balance}")
  }
 
  def getBalance: Double = balance
  
 
  override def toString: String = f"Account balance: $$${balance}%.2f"
}

object AccountTest extends App {
  val account1 = new Account(500.0)
  val account2 = new Account(200.0)
  
  println(account1) 
  println(account2) 
  
  account1.deposit(100.0) 
  account1.withdraw(50.0) 
  
  account1.transfer(150.0, account2) 
  
  println(account1) 
  println(account2) 
}