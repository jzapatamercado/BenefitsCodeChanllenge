### Happy Fit 🙂
📃Happy Fit is a company that provides a benefits program which gives great discounts in certain e-commerce sites for all its subscribers.
This program consists of the following benefits:
- ☑️ When a customer pays with a Visa card, the program will provide the following benefits:
If the client buys 10 different products 🛒 or more, a 15% discount will be applied on the final amount to pay. 
In a different case if he buys 7 - 9 different products, a 10% discount will be applied on the final amount to pay
otherwise a 5% discount is applied on the final amount.
- ☑️ When a customer pays with a Mastercard card, the program will provide the following benefits:
If the client total amount 💵 to pay equals $100 or more, then a 17% discount will be applied on it. 
In a different case if the amount is in range of $75 - $99, a 12% discount will be applied. Otherwise, 
an 8% discount is applied no matter the amount.

🏁 Your job for this challenge is to make a refactor of the code already done to process the discounts conditions described above.
The goal is to reduce complexity and make it more SOLID. 
- ❗Feel free to apply any patterns you consider might fit. 
- ❗Make any changes you consider will also improve performance. 
- ❗Incorporate exception handling with at least one custom exception.
- ❗Refactor to allow creation of small testable units.
- ❗Write a simple Javadoc with essential information for one or more of the newly created methods or classes.

Recent Changes:
2023-02-10
Code Challenge refactor.

Method Order.pay() simplified and distributed in distinct specialized classes.
Strategy pattern applied to isolated the distinct types of payments with their own conditions.
Condition extended to support one or more attributes to be evaluated.
Logger included into the implementation.
Unit test to cover the distinct scenarios across the PayOrderSimulator added some negative scenarios.
Unit test implemented to test some relevant methods located in condition, discount and payment.
Custom exceptions to control minimal quantity and cost supported by the implementation.
Product generator improved to get an accurate set of products based on desired amount.
PayPal benefit implemented, giving the benefit if the number of products is 10+ or the cost amount is 100+
Generation of some model classes to separate their implementation from logic.
