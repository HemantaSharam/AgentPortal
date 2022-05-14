
 insert into PROPERTY_MASTER (minval,maxval,property_value)  values (0,1000000,0),(1000001,2000000,1),
									(2000001,3000000,2),(3000001,4000000,6),(4000001,5000000,4),
									(5000001,6000000,5),(6000001,7000000,6),(7000001,8000000,7),
									(8000001,9000000,8),(9000001,10000000,9),(10000001,100000000,10),(100000001,10000000000,11);
									


insert into consumer (c_Id,agentname,business_Type,dob,email,name,pan)  values  ('C01','Hemanta','Technology','1937-12-28','ratan123@gmail.com','Ratan Tata','JPXQO4642');


insert into business (b_id,business_type,capital_invested,no_of_employees,turn_over,business_value,c_id)  values 
																							( 'B01','Technology',128000000,420000,800000000,6,'C01'),
 																							( 'B02','Retail',89000000,210000,200000000,2,'C01'),
 																							( 'B03','Motor',68000000,180000,520000000,7,'C01');
insert into property (p_id,building_age,building_area,building_storey,building_type,cost_of_asset,salvage_value,useful_life,property_value,b_id) values 
																				('P01',30,50000,18,'Owner',650000000,200000000,50,9,'B01'),
																				('P02',15,25000,10,'Owner',420000000,150000000,40,6,'B02'),
																				('P03',5,60000,25,'Rent',800000000,400000000,50,8,'B02');