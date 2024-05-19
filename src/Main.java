import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Perceptron perceptron = new Perceptron(2, 0.05); // 2 entrées, 1 sortie, taux d'apprentissage = 0.1
        Perceptron perceptron1 = new Perceptron(2, 0.05); // 2 entrées, 1 sortie, taux d'apprentissage = 0.1
        Perceptron perceptron2 = new Perceptron(2, 0.05); // 2 entrées, 1 sortie, taux d'apprentissage = 0.1

        perceptron.setWeights(new double[]{0.11, 0.21});
        perceptron1.setWeights(new double[]{0.12, 0.08});
        perceptron2.setWeights(new double[]{0.14, 0.15});

        double[][] inputs = {
                {2, 3},
        };
        double[] targetResults = {1, 1, 1, 0};

        for (int i = 0; i < 100; i++) { // 10 000 itérations d'apprentissage
            for (int j = 0; j < inputs.length; j++) {
                // forward
                double predict1 = perceptron.predict(inputs[j]);
                double predict2 = perceptron1.predict(inputs[j]);
                double predict3 = perceptron2.predict(new double[]{predict1, predict2});
                double error = predict3 - targetResults[j];

                System.out.println("Forward p0 = " + predict1);
                System.out.println("Forward p1 = " + predict2);
                System.out.println("Forward p2 = " + predict3);
                System.out.println("error output = " + error);
                System.out.println("predict " + i + " " + j + " : " + predict3 + " " + Arrays.toString(perceptron2.getWeights()));

                perceptron.trainWithError(
                        inputs[j],
                        error,
                        perceptron2.getWeights()
                );
                perceptron1.trainWithError(
                        inputs[j],
                        error,
                        perceptron2.getWeights()
                );
                perceptron2.train(
                        new double[]{predict1, predict2},
                        targetResults[j]
                );
            }
        }
        double[] inputsTest = {0, 1};
        double output = perceptron.predict(inputsTest);
        double output1 = perceptron1.predict(inputsTest);
        double output2 = perceptron2.predict(new double[]{output, output1});
        System.out.println("Sortie : " + output);
        System.out.println("Sortie1 : " + output1);
        System.out.println("Sortie2 : " + output2);
    }
}
