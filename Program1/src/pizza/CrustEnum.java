package pizza;

//A small pizza costs $5.99, a medium is $7.99, and a large is $9.99.
enum CrustSize
{
	S(5.99, 'S'), M(7.99, 'M'), L(9.99, 'L');
	private double cost;
	private char size;
	
	CrustSize(double cost, char size)
	{
		this.cost = cost;
		this.size = size;
	}

	double getCost() 
	{ 
		return cost; 
	}

	char getSize() 
	{ 
		return size; 
	}

};

// A hand-tossed crust is an additional $0.50, and a deep dish pan crust is an additional $1.00. 
enum CrustType
{
	THIN(0.00,"THIN"), HAND(0.50, "HAND"), PAN(1.00, "PAN");
	private double cost;
	private String type;
	
	CrustType(double cost, String type)
	{
		this.cost = cost;
		this.type = type;
	}

	double getCost() 
	{ 
		return cost; 
	}

	String getType() 
	{ 
		return type; 
	}
};