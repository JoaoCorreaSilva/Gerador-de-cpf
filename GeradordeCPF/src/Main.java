import java.util.Random;

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            String cpf = gerarCPF();
            System.out.println(cpf);
        }
    }

    public static String gerarCPF() {
        Random random = new Random();
        int[] cpfArray = new int[9];

        // Gera os primeiros 9 dígitos do CPF
        for (int i = 0; i < 9; i++) {
            cpfArray[i] = random.nextInt(10);
        }

        // Calcula dígito verificador
        int digito1 = calcularDigitoVerificador(cpfArray, 10);

        int digito2 = calcularDigitoVerificador(cpfArray, 11);

        StringBuilder cpfBuilder = new StringBuilder();
        for (int i : cpfArray) {
            cpfBuilder.append(i);
        }
        cpfBuilder.append(digito1).append(digito2);

        return formatarCPF(cpfBuilder.toString());
    }

    private static int calcularDigitoVerificador(int[] cpfArray, int base) {
        int soma = 0;
        for (int i = 0; i < cpfArray.length; i++) {
            soma += cpfArray[i] * (base - i);
        }
        int resto = soma % 11;
        return (resto < 2) ? 0 : (11 - resto);
    }

    private static String formatarCPF(String cpf) {
        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9);
    }
}
