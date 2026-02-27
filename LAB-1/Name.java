public class Name {
    public static void main(String[] args){
        System.out.println("Hello World!");

        String[] languages = {
                "C", "C++", "C#", "Python", "Go", "Rust",
                "JavaScript", "PHP", "Swift", "Java"
        };


        int n = (int) (Math.random() * 1_000_000);


        int result = n;
        result *= 3;
        result += 0b10101;
        result += 0xFF;
        result *= 6;

        result = reduceToOneDigit(result);
        System.out.println("Willy-nilly, this semester I will learn " + languages[result] + ".");
    }

    private static int reduceToOneDigit(int x) {
        x = Math.abs(x);
        while (x >= 10) {
            int sum = 0;
            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }
            x = sum;
        }
        return x;
    }
}
