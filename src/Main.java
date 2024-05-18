import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Perceptron perceptron = new Perceptron(2, 0.1); // 2 entrées, 1 sortie, taux d'apprentissage = 0.1

        double[][] inputs = {
                {0, 0},
                {0, 1},
                {1, 0},
                {1, 1},
        };
        double[] targetResults = {0, 1, 1, 1};

        for (int i = 0; i < 10000; i++) { // 10 000 itérations d'apprentissage
            for (int j = 0; j < inputs.length; j++) {
                perceptron.train(inputs[j], targetResults[j]);
                System.out.println("predict " + i + " " + j + " : " + perceptron.predict(inputs[j]) + " " + Arrays.toString(perceptron.getWeights()));
            }
        }
        double[] inputsTest = {0, 1};
        double output = perceptron.predict(inputsTest);
        System.out.println("Sortie : " + output);
    }
}
