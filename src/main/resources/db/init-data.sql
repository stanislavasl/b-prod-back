INSERT INTO PRODUCTS(product_id, product_name)
VALUES (11111, 'Current Account'),
       (22222, 'Current Account Plus'),
       (33333, 'Junior Saver Account'),
       (44444, 'Student Account'),
       (55555, 'Debit Card'),
       (66666, 'Credit Card'),
       (77777, 'Gold Credit Card');

INSERT INTO CUSTOMERS(customer_id, customer_personal_code, first_name, second_name, age, is_student, annual_income)
VALUES (1, 38812130509, 'Petras', 'Petraitis', 35, 'no', 25000),
       (2, 35012150239, 'Jonas', 'Jonaitis', 73, 'no', 8000),
       (3, 60312312496, 'Ona', 'Petraityte', 23, 'yes', 5000);

INSERT INTO BUNDLES(bundle_id, bundle_value, bundle_name, account, debit_card, credit_card)
VALUES (1, 0, 'Junior Saver', 33333, null, null),
       (2, 0, 'Student', 44444, 55555, 66666),
       (3, 1, 'Classic', 11111, 55555, null),
       (4, 2, 'Classic Plus', 11111, 55555, 66666),
       (5, 3, 'Gold', 22222, 55555, 77777);