import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Main {


    public static void main(String[] args) {

        String filename="C:\\Users\\ddunn\\IdeaProjects\\j2b2w2opdracht2\\src\\Homo_sapiens.gene_info";

        long start_linked_read = System.nanoTime();
        LinkedList<Gene> genes= readFile(filename);
        long end_linked_read=System.nanoTime();

        long start_array_read =System.nanoTime();
        ArrayList<Gene> genesa = readFileArray(filename);
        long end_array_read=System.nanoTime();

        System.out.println(genes);

        long start_linked_select =System.nanoTime();
        Gene item_out_linked= genes.get(6);
        long end_linked_select=System.nanoTime();

        long start_array_select = System.nanoTime();
        Gene item_out_array =genes.get(6);
        long end_array_select=System.nanoTime();


        Collections.sort(genes);
        Collections.sort(genesa);

        System.out.println(genes);
        LinkedList<Gene>[] groupedGenes= group(genes);
        ArrayList<Gene>[] groupedGenesA =group(genesa);

        System.out.println(Arrays.toString(groupedGenes));

        long time_linked_read= end_linked_read-start_linked_read;
        long time_array_read=end_array_read-start_array_read;
        long time_linked_select=end_linked_select-start_linked_select;
        long time_array_select= end_array_select-start_array_select;
        System.out.println(time_linked_read+"\n"+time_array_read+"\n" +time_linked_select+"\n"+time_array_select);
    }

    public static LinkedList<Gene>[] group(LinkedList<Gene> genes){
        LinkedList[] result = new LinkedList[25];
        for(int j=0;j<25;j++){
            LinkedList<Gene> temp = new LinkedList<>();
            result[j]=new LinkedList<Gene>();
            for (Gene gene : genes) {
                if (gene.getChromosome() == j) {
                    temp.add(gene);
                }
            }
        result[j].add(temp);}

        return result; }

    public static ArrayList<Gene>[] group(ArrayList<Gene> genes){
        ArrayList[] result = new ArrayList[25];
        for(int j=0;j<25;j++){
            LinkedList<Gene> temp = new LinkedList<>();
            result[j]=new ArrayList<Gene>();
            for (Gene gene : genes) {
                if (gene.getChromosome() == j) {
                    temp.add(gene);
                }
            }
            result[j].add(temp);}

        return result; }


    public static LinkedList<Gene> readFile(String filename) {
        String line;
        BufferedReader inFile = null;
        try {
            inFile = new BufferedReader(new FileReader(filename));
            LinkedList<Gene> genes=new LinkedList<>();
            inFile.readLine();
            while ((line = inFile.readLine()) != null) {
                String[] attributes=line.split("\t");
                int gene_id=Integer.parseInt(attributes[1]);
                String symbol= attributes[2];
                String Chromosome_map_location =attributes[7];
                String Chromosoom= attributes[6];
                genes.add(new Gene(gene_id,symbol,Chromosome_map_location,Chromosoom));
            }
            return genes;

        }
        catch (IOException|NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    e.getMessage());
            return null;
        }
        finally {
            try {
                inFile.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null,
                        e.getMessage());
            }
        }
    }

    public static ArrayList<Gene> readFileArray(String filename) {
        String line;
        BufferedReader inFile = null;
        try {
            inFile = new BufferedReader(new FileReader(filename));
            ArrayList<Gene> genes=new ArrayList<>();
            inFile.readLine();
            while ((line = inFile.readLine()) != null) {
                String[] attributes=line.split("\t");
                int gene_id=Integer.parseInt(attributes[1]);
                String symbol= attributes[2];
                String Chromosome_map_location =attributes[7];
                String Chromosoom= attributes[6];
                genes.add(new Gene(gene_id,symbol,Chromosome_map_location,Chromosoom));
            }
            return genes;

        }
        catch (IOException|NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    e.getMessage());
            return null;
        }
        finally {
            try {
                inFile.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null,
                        e.getMessage());
            }
        }
    }




}
