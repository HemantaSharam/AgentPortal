insert into POLICY_MASTER (Id, Property_Type, Consumer_Type, Assured_Sum, Tenure, Business_Value, Property_Value, Base_Location, Type) values 
										('P01', 'Building', 'Owner', 20000000, 3, 8, 5, 'Chennai', 'Replacement'),
										('P02', 'Land', 'Owner', 400000, 1, 7, 0, 'Chennai', 'Replacement'),
										('P03', 'Building', 'Rent', 200000, 1, 2, 7, 'Pune', 'Pay Back'),
										('P04', 'Building', 'Owner', 20000000, 5, 6, 9, 'Kolkata', 'Replacement');

insert into CONSUMER_POLICY (CONSUMER_ID, ACCEPTANCE_STATUS, BUSINESS_ID, PAYMENT_DETAILS,POLICY_ID) values ('C01', true, 'B01', 'UPI', 'P04');