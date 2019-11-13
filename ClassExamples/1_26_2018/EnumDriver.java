package csc2310;

//possible ingredients for alchemy
//much better than using integers, enums allow self-explanatory values
//enum IngredientType {MUSHROOM, FERN, FROG, BIRDFOOT, FLOWER, MANDRAKE, SCORPION, FEATHER};

public class EnumDriver
{

	public static void main(String[] args)
	{
		//IngredientType ingredient_type_1 = IngredientType.SCORPION;
		//System.out.println(ingredient_type_1);
		
		//what if you want to print out all of the allowed values in the enumeration
		/*
		IngredientType[] ingredient_types = IngredientType.values();
		for (IngredientType ingredient_type : ingredient_types)
		{
			System.out.println(ingredient_type);
		}
		*/
		IngredientType i_type = IngredientType.getIngredientType(4);
		System.out.println(i_type);
		
		//actually, enumerations are classes in Java, so we can do a lot more with them
	}
}

enum IngredientType
{
	//each enumeration "value" is actually an object of the IngredientType class
	MUSHROOM (1,"mushroom"), FERN (2,"fern"), FROG (3,"frog"), BIRDFOOT (4,"birdfoot"), FLOWER (5,"flower"), MANDRAKE (6,"mandrake"), SCORPION (7,"scorpion"), FEATHER (8,"feather"), INVALID (0,"invalid");
	
	private int value;
	private String name;
	
	private static IngredientType[] ingredient_types = IngredientType.values();
	
	//assumes enums are defined in ascending order by value (1-based)
	static IngredientType getIngredientType(int ingredient_index)
	{
		return ingredient_types[ingredient_index-1];
	}
	
	private IngredientType(int val, String n) 
	{ 
		value = val;
		name = n;
	}
	
	public int getValue() 
	{ 
		return value; 
	}
	
	public String getName() 
	{ 
		return name; 
	}
};

