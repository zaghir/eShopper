insert into acriss_car_code1(code ,categorie ) values("M","Mini") ,
       ("N","Mini Elite") , ("E","Economy"), ("H","Economy Elite"), ("C","Compact"),
       ("D","Compact Elite"), ("I","Intermediate"), ("J"," 	Intermediate Elite"),
       ("S","Standard"), ("R","Standard Elite"), ("F","Fullsize"), ("G","Fullsize Elite"),
       ("P","Premium"), ("U","Premium Elite"), ("L","Luxury"), ("W","Luxury Elite"),
       ("O","Oversize") , ("X","Special");

insert into acriss_car_code2(code , type_vehicule) values("B","2-3 Door"),
      ("C","2/4 Door"), ("D","4-5 Door"), ("W","Wagon/Estate"), ("V"," 	Passenger van"),
      ("L","Limousine"), ("S","Sport"), ("T","Convertible"), ("F","SUV"),
      ("J","Open-air All Terrain"), ("X","Special"), ("P","Pickup (regular cab)"),
      ("Q"," 	Pickup (extended cab)"), ("Z"," Special offer Car"), ("E","Coupe"),
      ("M","Monospace"), ("R","Recreational vehicle"), ("H","Motorhome"), ("Y","2-wheel vehicle"),
      ("N","Roadster") , ("G","Crossover"), ("K","Commercial van/truck");
      
insert into acriss_car_code3(code , transmission , drive) values("M","Manual" ,"Unspecified"),
      ("N","Manual" ,"4-wheel"), ("C","Manual","All-wheel"), ("A","Automatic","Unspecified"),
      ("B","Automatic","4-wheel"), ("D","Automatic","All-wheel") ;
      
insert into acriss_car_code4(code , fuel , air_condition) values("R","Unspecified","Yes"),
       ("N","Unspecified","No"), ("D","Diesel","Yes"), ("Q","Diesel","No"), ("H","Hybrid","Yes"),
       ("I","Hybrid","No"), ("E","Electric","Yes"), ("C","Electric","No"), ("L","LPG","Yes"), 
       ("S","LPG","No"), ("A","Hydrogen","Yes"), ("B","Hydrogen","No"), ("M","Multifuel","Yes"), 
       ("F","Multifuel","No"), ("V","Petrol","Yes"), ("Z","Petrol","No"), ("U","Ethanol","Yes"), ("X","Ethanol","No"); 
       
insert into users(username , password , actived) values("youssef","123",1) , ("vincent","123",1) , ("laid","123",1) ,
		("abdelhak","123",1) , ("mohammed","123",1) , ("mike","123",0);

insert into role(role , description) values("admin","administrateur") , ("client","client") ;

insert into users_roles(users , roles ) values("youssef","admin") , ("vincent","admin") , ("laid","admin") ,
		("abdelhak","admin") , ("mohammed","admin") , ("mike","admin") ;

insert into compagnie_vehicule (nom) values("HERTZ") , ("AVIS"),("FIREFLY") ,("SIXT"), ("ACE") ,("BUDGET");

insert into devis(code , nom) values("EUR" ,"EURO ") ,("US", "DOLARS");

insert into tarifs_vehicule(type) values("Par Jour") , ("Par Semaine") , ("Par mois");

insert into agence_auto(nom ,adresse ,ville , pays ,latitude_location , longitude_location , compagnie_id) 
   values ("adresse HERTZ Paris" , "12 rue Paris" ,"Paris" , "France" , 12.2 , 15.25 , 1 ) ,
    ("adresse HERTZ Lyon" , "12 rue Lyon" ,"Lyon" , "France" , 555.2 , 999.25 , 1 ) ,
    ("adresse HERTZ Toulouse" , "12 rue Toulouse" ,"Toulouse" , "France" , 777.2 , 111.25 , 1 ) ;
