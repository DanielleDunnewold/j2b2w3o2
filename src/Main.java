import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Main {


    public static void main(String[] args) {

        // the name of the file name with the information of all the genes of the homo sapiens
        String filename="C:\\Users\\ddunn\\IdeaProjects\\j2b2w2opdracht2\\src\\Homo_sapiens.gene_info";

        // this measures the time it takes to read in the file and stores the information in a linkedlist
        long start_linked_read = System.nanoTime();
        LinkedList<Gene> genes= readFile(filename);
        long end_linked_read=System.nanoTime();

        //this measures the time it takes to read in the file and stores the information in a Arraylist
        long start_array_read =System.nanoTime();
        ArrayList<Gene> genesa = readFileArray(filename);
        long end_array_read=System.nanoTime();

        //this measures the time it takes to select a gene out of a linked list
        long start_linked_select =System.nanoTime();
        Gene item_out_linked= genes.get(6);
        long end_linked_select=System.nanoTime();

        //this measures the time it takes to select a gene out od arraylist
        long start_array_select = System.nanoTime();
        Gene item_out_array =genes.get(6);
        long end_array_select=System.nanoTime();

        //this sorts the genes in the linkedlist
        Collections.sort(genes);
        //this sorts the genes in the arraylist
        Collections.sort(genesa);

        //this groups the Genes in the linkedlist
        LinkedList<Gene>[] groupedGenes= group(genes);
        //this groups the Genes in the arraylist
        ArrayList<Gene>[] groupedGenesA =group(genesa);

        //this prints a array of linkedlists grouped per chromosoom
        System.out.println(Arrays.toString(groupedGenes));

        //this prints a array of Arraylists grouped per chromosoom
        System.out.println(Arrays.toString(groupedGenesA));

        //this calculates all the end times that were measured in the script
        long time_linked_read= end_linked_read-start_linked_read;
        long time_array_read=end_array_read-start_array_read;
        long time_linked_select=end_linked_select-start_linked_select;
        long time_array_select= end_array_select-start_array_select;
        //prints out all the times
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
            inFile.readLine();   //delete first line
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
