# CS21B033_ATM
# I used the OOPS concepts of abstraction , inheritence in this program
# I've used abstraction to secure the account numbers and inheritence in pins class . I've extended pins class so that I can define an object which can access both pins and accounts class at once.
# My code has abstract class and normal classes.
# Abstract class Account has all the accounts in this atm.
# The class pins contains passwords of all the accounts in this atm.
# The class balance has the balance of each account.
# The method dispenceCash takes 5 inputs. When the user withdraws money , this functiom is called and it will display the number of different types of currency notes the user gets.
     Ex :- if the user withdraws 700 , it will show "1 Five hundred notes , 1 Two hundred notes"
# The boolean method Check takes a string input. It checks whether the input is a string with only integer like "457242" . If it is an integer , it returns true ,  else it returns false.
# the variables twoK , fiveH , twoH , oneH are the initial number of respective currency notes in atm.
# I put a while loop before displaying 'Welcome' etc, because after the user logs out after using atm , it should again display 'Welcome' for the next user.
# Since the account number and pins are initially a five digit integers , I've writen another while loop which checsk whether the given input for account number and pin are actually defined inputs or not. If the input is not one of the defined values of account number or pins , the atm asks the user to re-enter properly. In case of  pins , the user has only three chances to give correct pin.
# If the user fails to give correct pin in 3 tries , they can't access their account.
# After logging in , the atm displays menu to the user. The user gets 5 options:
1. Check Balance
2. Withdraw
3. Deposit
4. Change pin
5. Exit
# The user gets an option to enter a number from 1 to 5.
# I've put the menu inside a while loop , so that if the user chooses an option and completes his work in it , it returns back to the menu as user may aslo want to check other options or to log out of his account.
# '1' is check balance. It shows the current balance in user's account
# '2' is wirhdraw. It allows the user to enter the amount he/she wants to withdraw from their account.
# The withdrawl money has to be a multiple of 100 and <= total balance.
# dispenceCash function is being used here to display currency notes.
# the withdrawn money is subtracted from user's account and remaining balace is displayed on the screen.
# '3' is deposit. It allowes user to enter amount to deposit money in their account.
# The deposited money is added to user's account and the final balance is displayed on the screen.
# '4' is change pin. The user has to enter his new password and ut is stored in string 'ne' . 
# For safety , the user has to enter the new password again . This is stored in string 'nee' . 
# If 'ne' is not the same as 'nee' , the user will get a message to re-confirm properly and is asked to go through this process from the start.
# if 'ne' is same as 'nee' , the user's account has a new password and he gets a message that the pin has been successfully changed.
# '5' is exit. The user is thanked for using this atmand is looged out from his account. The atm again displays "Welcome , please enter your account number' on the screen for the next user.(As it is in a while loop)
