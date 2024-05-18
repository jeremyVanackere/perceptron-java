
public class Perceptron {
    private double[] weights;
    private double learningRate;
    private int inputSize;
    private double biais = 0.5;

    public Perceptron(int inputSize, double learningRate) {
        this.inputSize = inputSize;
        this.learningRate = learningRate;
        this.weights = new double[inputSize];
        for (int i = 0; i < inputSize; i++) {
            weights[i] = 0; // initialisation des poids
        }
    }

    public double predict(double[] inputs) {
        double sum = 0;
        for (int i = 0; i < inputs.length; i++) {
            sum += inputs[i] * weights[i];
        }
        return sigmoid(sum + biais);
    }

    public void train(double[] inputs, double outputResult) {
        double output = predict(inputs);
        double error = outputResult - output;
        if (error != 0) {
            for (int i = 0; i < inputSize; i++) {
                weights[i] += learningRate * error * inputs[i];
            }
            biais += learningRate * error;
        }
    }

    private double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }

    public double[] getWeights() {
        return weights;
    }

    public void setWeights(double[] weights) {
        this.weights = weights;
    }

    public double getLearningRate() {
        return learningRate;
    }

    public void setLearningRate(double learningRate) {
        this.learningRate = learningRate;
    }

    public int getInputSize() {
        return inputSize;
    }

    public void setInputSize(int inputSize) {
        this.inputSize = inputSize;
    }
}