package br.com.ras.java.io;

import br.com.ras.java.shared.LogUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IOMain extends LogUtil {
    public static void main(String[] args) throws Exception {
        reader();

        exceptionTest();
    }

    private static void reader() {
        outTime("inicio : reader");
        // decorators
        // Litura de o arquivo de um diretorio - final InputStream inputStream = new FileInputStream("lorem.txt");

        final InputStream inputStream = IOMain.class.getClassLoader().getResourceAsStream("lorem.txt"); // leitura da pasta resource
        if (inputStream == null) throw new IllegalArgumentException("Arquivo nao encontrado");

        final InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        try (final BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            String linha;
            while ((linha = bufferedReader.readLine()) != null && !linha.isEmpty()) {
                outln(linha);
            }
        } catch (IOException ioex) {
            outln("ERRO ao realizar leitura arquivo :: " + ioex.getMessage());
        } catch (Exception ex) {
            outln("ERRO :: " + ex.getMessage());
        }
        outTime("fim : reader");
    }

    private static void exceptionTest() throws Exception {
        outln("TesteException");
        try {
            throw new Exception("TESTE");
        } catch (TestException ie) {
            outln("runtime");
            throw ie;
        } catch (Exception ex) {
            outln("exception");
        }
    }

    private static class TestException extends RuntimeException {
        public TestException(String message) {
            super(message);
        }
    }
}
