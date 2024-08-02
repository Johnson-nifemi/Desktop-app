public class Person {
    private double weight; // in kilograms
    private double height; // in meters

    public Person(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public String getBodyType() {
        double bmi = weight / (height * height);
        if (bmi < 18.5) {
            return "Slim";
        } else if (bmi < 25) {
            return "Chubby";
        } else {
            return "Fat";
        }
    }

    public String getHeightType() {
        if (height < 1.7) {
            return "Short";
        } else {
            return "Tall";
        }
    }
}
