public class Program {
    public static void main(String[] args) {
        Sensor atlanta = new TemperatureSensor();
        Sensor savannah = new TemperatureSensor();
        Sensor macon = new TemperatureSensor();

        AverageSensor georgia = new AverageSensor();
        georgia.addSensor(atlanta);
        georgia.addSensor(savannah);
        georgia.addSensor(macon);

        georgia.setOn();
        System.out.println("temperature in Georgia " + georgia.read() + " degrees Celsius");
        System.out.println("temperature in Georgia " + georgia.read() + " degrees Celsius");
        System.out.println("temperature in Georgia " + georgia.read() + " degrees Celsius");

        System.out.println("readings: " + georgia.readings());
    }
}
