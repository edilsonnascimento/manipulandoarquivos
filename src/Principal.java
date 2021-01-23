import java.io.*;

public class Principal {

    public static void main(String[] args) {
         primeiroExercicio();
         segundoExercicio(args);

    }

    private static void segundoExercicio(String[] args){

        String arquivoPesquisado = args[0];

        File diretorioRaiz = new File("C:/");
        File listaArquivos[]  = diretorioRaiz.listFiles();

        boolean arquioExiste = false;
        for(int i = 0; i < listaArquivos.length; i++) {
            if (listaArquivos[i].getName().equals(arquivoPesquisado)) {
                arquioExiste = true;
                System.out.println("Arquivo já criado...");
            }
        }
        if(!arquioExiste){
            try(FileWriter novoArquivo = new FileWriter("C:/" + arquivoPesquisado)) {
                PrintWriter gravarNovoArquivo = new PrintWriter(novoArquivo);
                for(int i = 0; i < args.length; i++){
                    gravarNovoArquivo.print(" " + args[i]);
                }
            }catch (IOException exc){
                System.out.println("Erro ao criar novo arquivo");
            }

        }
    }

    private static void primeiroExercicio(){
        File diretorioRaiz = new File("C:/MJV");
        File listaArquivos[]  = diretorioRaiz.listFiles();

        for(int i = 0; i < listaArquivos.length; i++){

            if(listaArquivos[i].isFile()){
                System.out.println(listaArquivos[i] + " - Arquivo");
            }else if(listaArquivos[i].isDirectory()){
                System.out.println(listaArquivos[i] + " - Diretório");
            }else {
                System.out.println(listaArquivos[i] + " - Não testado");
            }
        }

    }
}
