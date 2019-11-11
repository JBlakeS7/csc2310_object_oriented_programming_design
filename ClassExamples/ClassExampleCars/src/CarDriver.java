public class CarDriver
{
    public static void main(String[] args)
    {
        Car fit = new Car("Honda", "Fit", 2015, "VIN1234567890", 19000, 4, 2.5, 30);
        Car vette = new Car("Chevrolet", "Corvette", 2000, "VIN1111111111", 25000,5, 3, 32);
        Car s300 = new Car("Mercedes", "S300", 2005, "VIN2222222222", 30000, 4.5, 2.75, 31);
        Car porsche = new Car("Porsche", "718 Cayman S", 2018, "VIN3333333333", 69300, 5, 3, 33);
        
        CarCollection all_the_cars = new CarCollection();
        all_the_cars.add(fit);
        all_the_cars.add(vette);
        all_the_cars.add(s300);
        all_the_cars.add(porsche);
        
        NewCarCommand new_car_cmd = new NewCarCommand();
        all_the_cars.execute(new_car_cmd);
        System.out.println("# of new cars in collection: " + new_car_cmd.getNumNewCars());
        
        NewCarVisitor new_car_visitor = new NewCarVisitor();
        all_the_cars.accept(new_car_visitor);
        System.out.println("# of new cars in collection: " + new_car_visitor.getNumNewCars());
        
        // all_the_cars.execute(new SimulateCarTroubleCommand());
        SimulateCarTroubleVisitor trouble = new SimulateCarTroubleVisitor();
        all_the_cars.accept(trouble);
        System.out.println("Trouble results:");
        System.out.println(trouble.getReport());
        System.out.println();
        CarDiagnosticVisitor checkup = new CarDiagnosticVisitor(20);
        all_the_cars.accept(checkup);
        System.out.println("Diagnosis results:");
        System.out.println(checkup.getReport());
        
    }
}