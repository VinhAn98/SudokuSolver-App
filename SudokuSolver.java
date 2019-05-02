// A Java program to implement greedy algorithm for graph coloring
import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

// This class represents an undirected graph using adjacency list
class SudokuSolver 
{
    private Graph g;  
    private int cColored;
    private   int[][] array;
    public Writer fileOut;
    //Constructor
    SudokuSolver(int v, String name)
    {
        cColored = 0;
	
        g = new Graph(v);
      //  g.readGraph(name,int v);
	 //int[][] temp= new int[12][12];
	 this.array=this.g.readGraph(name);
    //this.g.printGraph(array);
    //int[][] cmp= new int[12][12];
    // vertice 1 block 1
    for(int i=1;i<12;i++){
       this.g.addEdge(0,i);
    }
    for(int i = 12;i<133;i=i+12){
       this.g.addEdge(0,i);
    }
    for(int i = 13;i<16;i++){
       this.g.addEdge(0,i);
    }
    for(int i = 25;i<28;i++){
       this.g.addEdge(0,i);
    }
    // vertice 2 block 1
    for(int i=2;i<12;i++){
       this.g.addEdge(1,i);
    }
    for(int i = 13;i<134;i=i+12){
       this.g.addEdge(1,i);
    }
    for(int i = 12;i<16;i++){
      if(i == 13)
        continue;
       this.g.addEdge(1,i);
    }
    for(int i = 24;i<28;i++){
      if(i==25)
        continue;
       this.g.addEdge(1,i);
    }
    // vertice 3 block 1
    for(int i=3;i<12;i++){
       this.g.addEdge(2,i);
    }
    for(int i = 14;i<135;i=i+12){
       this.g.addEdge(2,i);
    }
    for(int i = 12;i<16;i++){
      if(i == 14)
        continue;
       this.g.addEdge(2,i);
    }
    for(int i = 24;i<28;i++){
      if(i==26)
        continue;
       this.g.addEdge(2,i);
    }
    // vertice 4 block 1
    for(int i=4;i<12;i++){
       this.g.addEdge(3,i);
    }
    for(int i = 15;i<136;i=i+12){
       this.g.addEdge(3,i);
    }
    for(int i = 12;i<16;i++){
      if(i == 15)
        continue;
       this.g.addEdge(3,i);
    }
    for(int i = 24;i<28;i++){
      if(i==27)
        continue;
       this.g.addEdge(3,i);
    }
    // vertice 5 block 2
    for(int i=5;i<12;i++){
       this.g.addEdge(4,i);
    }
    for(int i = 16;i<137;i=i+12){
       this.g.addEdge(4,i);
    }
    for(int i = 17;i<20;i++){
       this.g.addEdge(4,i);
    }
    for(int i = 28;i<32;i++){
      if(i==28)
        continue;
       this.g.addEdge(4,i);
    }
    //  vertice 6 block 2
    for(int i=6;i<12;i++){
       this.g.addEdge(5,i);
    }
    for(int i = 17;i<138;i=i+12){
       this.g.addEdge(5,i);
    }
    for(int i = 16;i<20;i++){
      if(i==17)
        continue;
       this.g.addEdge(5,i);
    }
    for(int i = 28;i<32;i++){
      if(i==29)
        continue;
       this.g.addEdge(5,i);
    }
    //vertice 7 block 2
     for(int i=7;i<12;i++){
       this.g.addEdge(6,i);
    }
    for(int i = 18;i<139;i=i+12){
       this.g.addEdge(6,i);
    }
    for(int i = 16;i<20;i++){
      if(i==18)
        continue;
       this.g.addEdge(6,i);
    }
    for(int i = 28;i<32;i++){
      if(i==30)
        continue;
       this.g.addEdge(6,i);
    }
    //vertice 8 block 2
    for(int i=8;i<12;i++){
       this.g.addEdge(7,i);
    }
    for(int i = 19;i<140;i=i+12){
       this.g.addEdge(7,i);
    }
    for(int i = 16;i<20;i++){
      if(i==19)
        continue;
       this.g.addEdge(7,i);
    }
    for(int i = 28;i<32;i++){
      if(i==31)
        continue;
       this.g.addEdge(7,i);
    }
    //vertice 9 block 3
    for(int i=9;i<12;i++){
       this.g.addEdge(8,i);
    }
    for(int i = 20;i<141;i=i+12){
       this.g.addEdge(8,i);
    }
    for(int i = 20;i<24;i++){
      if(i==20)
        continue;
       this.g.addEdge(8,i);
    }
    for(int i = 32;i<36;i++){
      if(i==32)
        continue;
       this.g.addEdge(8,i);
    }
    //vertice 10 block 3
    for(int i=10;i<12;i++){
       this.g.addEdge(9,i);
    }
    for(int i = 21;i<142;i=i+12){
       this.g.addEdge(9,i);
    }
    for(int i = 20;i<24;i++){
      if(i==21)
        continue;
       this.g.addEdge(9,i);
    }
    for(int i = 32;i<36;i++){
      if(i==33)
        continue;
       this.g.addEdge(9,i);
    }
    //vertice 11 block 3
       for(int i=11;i<12;i++){
       this.g.addEdge(10,i);
    }
    for(int i = 22;i<143;i=i+12){
       this.g.addEdge(10,i);
    }
    for(int i = 20;i<24;i++){
      if(i==22)
        continue;
       this.g.addEdge(10,i);
    }
    for(int i = 32;i<36;i++){
      if(i==34)
        continue;
       this.g.addEdge(10,i);
    }
    //vertice 12 block 3
     
    for(int i = 23;i<144;i=i+12){
       this.g.addEdge(11,i);
    }
    for(int i = 20;i<24;i++){
      if(i==23)
        continue;
       this.g.addEdge(11,i);
    }
    for(int i = 32;i<36;i++){
      if(i==35)
        continue;
       this.g.addEdge(11,i);
    }
    // vertice 13 block 1
     for(int i=13;i<24;i++){
       this.g.addEdge(12,i);
    }
    for(int i = 24;i<133;i=i+12){
       this.g.addEdge(12,i);
    }
    for(int i = 24;i<28;i++){
       if(i==24)
        continue;
       this.g.addEdge(12,i);
    }
    // vertice 14 block 1
     for(int i=14;i<24;i++){
       
       this.g.addEdge(13,i);
    }
    for(int i = 25;i<134;i=i+12){
       this.g.addEdge(13,i);
    }
    for(int i = 24;i<28;i++){
       if(i==25)
        continue;
       this.g.addEdge(13,i);
    }
    // vertice 15 block 1
     for(int i=15;i<24;i++){
       
       this.g.addEdge(14,i);
    }
    for(int i = 26;i<135;i=i+12){
       this.g.addEdge(14,i);
    }
    for(int i = 24;i<28;i++){
       if(i==26)
        continue;
       this.g.addEdge(14,i);
    }
    //vertice 16 block 1
     for(int i=16;i<24;i++){
       
       this.g.addEdge(15,i);
    }
    for(int i = 27;i<136;i=i+12){
       this.g.addEdge(15,i);
    }
    for(int i = 24;i<28;i++){
       if(i==27)
        continue;
       this.g.addEdge(15,i);
    }
    //vertice 17 block 2
     for(int i=17;i<24;i++){
       
       this.g.addEdge(16,i);
    }
    for(int i = 28;i<137;i=i+12){
       this.g.addEdge(16,i);
    }
    for(int i = 28;i<32;i++){
       if(i==28)
        continue;
       this.g.addEdge(16,i);
    }
    // vertice 18 block 2
     for(int i=18;i<24;i++){
       
       this.g.addEdge(17,i);
    }
    for(int i = 29;i<138;i=i+12){
       this.g.addEdge(17,i);
    }
    for(int i = 28;i<32;i++){
       if(i==29)
        continue;
       this.g.addEdge(17,i);
    }
    // vertice 19 block 2
    for(int i=19;i<24;i++){
       
       this.g.addEdge(18,i);
    }
    for(int i = 30;i<139;i=i+12){
       this.g.addEdge(18,i);
    }
    for(int i = 28;i<32;i++){
       if(i==30)
        continue;
       this.g.addEdge(18,i);
    }
    // vertice 20 block 2
     for(int i=20;i<24;i++){
       
       this.g.addEdge(19,i);
    }
    for(int i = 31;i<140;i=i+12){
       this.g.addEdge(19,i);
    }
    for(int i = 28;i<32;i++){
       if(i==31)
        continue;
       this.g.addEdge(19,i);
    }
    // vertice 21 block 3
     for(int i=21;i<24;i++){
       
       this.g.addEdge(20,i);
    }
    for(int i = 32;i<144;i=i+12){
       this.g.addEdge(20,i);
    }
    for(int i = 32;i<36;i++){
       if(i==32)
        continue;
       this.g.addEdge(20,i);
    }
    // vertice 22 block 3
    for(int i=22;i<24;i++){
       
       this.g.addEdge(21,i);
    }
    for(int i = 33;i<145;i=i+12){
       this.g.addEdge(21,i);
    }
    for(int i = 32;i<36;i++){
       if(i==33)
        continue;
       this.g.addEdge(21,i);
    }
    //vertice 23 block 3
     for(int i=23;i<24;i++){
       
       this.g.addEdge(22,i);
    }
    for(int i = 34;i<146;i=i+12){
       this.g.addEdge(22,i);
    }
    for(int i = 32;i<36;i++){
       if(i==34)
        continue;
       this.g.addEdge(22,i);
    }
    //vertice 24 block 3

    for(int i = 35;i<147;i=i+12){
       this.g.addEdge(23,i);
    }
    for(int i = 32;i<36;i++){
       if(i==35)
        continue;
       this.g.addEdge(23,i);
    }
    // vertice 25 block 1
    for(int i=25;i<36;i++){
       
       this.g.addEdge(24,i);
    }
    for(int i = 36;i<133;i=i+12){
       this.g.addEdge(24,i);
    }
   //vertice 26 block 1
    for(int i=26;i<36;i++){
       
       this.g.addEdge(25,i);
    }
    for(int i = 37;i<134;i=i+12){
       this.g.addEdge(25,i);
    }
    //vertice 27 block 1
    for(int i=27;i<36;i++){
       
       this.g.addEdge(26,i);
    }
    for(int i = 38;i<135;i=i+12){
       this.g.addEdge(26,i);
    }
    //vertice 28 block 1
    for(int i=28;i<36;i++){
       
       this.g.addEdge(27,i);
    }
    for(int i = 39;i<136;i=i+12){
       this.g.addEdge(27,i);
    }
    // vertice 29 block 2
    for(int i=29;i<36;i++){
       
       this.g.addEdge(28,i);
    }
    for(int i = 40;i<137;i=i+12){
       this.g.addEdge(28,i);
    }
    // vertice 30 block 2
    for(int i=30;i<36;i++){
       
       this.g.addEdge(29,i);
    }
    for(int i = 41;i<138;i=i+12){
       this.g.addEdge(29,i);
    }
    //vertice 31 block 2
     for(int i=31;i<36;i++){
       
       this.g.addEdge(30,i);
    }
    for(int i = 42;i<139;i=i+12){
       this.g.addEdge(30,i);
    }
    // vertice 32 block 2
      for(int i=32;i<36;i++){
       
       this.g.addEdge(31,i);
    }
    for(int i = 43;i<140;i=i+12){
       this.g.addEdge(31,i);
    }
    // vertice 33 block 3
    for(int i=33;i<36;i++){
       
       this.g.addEdge(32,i);
    }
    for(int i = 44;i<141;i=i+12){
       this.g.addEdge(32,i);
    }
    // vertice 34 block 3
    for(int i=34;i<36;i++){
       
       this.g.addEdge(33,i);
    }
    for(int i = 45;i<142;i=i+12){
       this.g.addEdge(33,i);
    }
    //vertice 35 block 3
    for(int i=35;i<36;i++){
       
       this.g.addEdge(34,i);
    }
    for(int i = 46;i<143;i=i+12){
       this.g.addEdge(34,i);
    }
    //vertice 36 block 3
    for(int i = 47;i<144;i=i+12){
       this.g.addEdge(35,i);
    }
    // vertice 37 block 4
    for(int i=37;i<48;i++){
       this.g.addEdge(36,i);
    }
    for(int i = 48;i<133;i=i+12){
       this.g.addEdge(36,i);
    }
    for(int i = 48;i<52;i++){
      if(i==48)
        continue;
       this.g.addEdge(36,i);
    }
    for(int i = 60;i<64;i++){
         if(i==60)
        continue;
       this.g.addEdge(36,i);
    }
    // vertice 38 block 4
     for(int i=38;i<48;i++){
       this.g.addEdge(37,i);
    }
    for(int i = 49;i<134;i=i+12){
       this.g.addEdge(37,i);
    }
    for(int i = 48;i<52;i++){
      if(i==49)
        continue;
       this.g.addEdge(37,i);
    }
    for(int i = 60;i<64;i++){
         if(i==61)
        continue;
       this.g.addEdge(37,i);
    }
    // vertice 39 block 4
       for(int i=39;i<48;i++){
       this.g.addEdge(38,i);
    }
    for(int i = 50;i<135;i=i+12){
       this.g.addEdge(38,i);
    }
    for(int i = 48;i<52;i++){
      if(i==50)
        continue;
       this.g.addEdge(38,i);
    }
    for(int i = 60;i<64;i++){
         if(i==62)
        continue;
       this.g.addEdge(38,i);
    }
    // vertice 40 block 4
    for(int i=40;i<48;i++){
       this.g.addEdge(39,i);
    }
    for(int i = 51;i<136;i=i+12){
       this.g.addEdge(39,i);
    }
    for(int i = 48;i<52;i++){
      if(i==51)
        continue;
       this.g.addEdge(39,i);
    }
    for(int i = 60;i<64;i++){
         if(i==63)
        continue;
       this.g.addEdge(39,i);
    }
    // vertice 41 block 5
     for(int i=41;i<48;i++){
       this.g.addEdge(40,i);
    }
    for(int i = 52;i<137;i=i+12){
       this.g.addEdge(40,i);
    }
    for(int i = 52;i<56;i++){
      if(i==52)
        continue;
       this.g.addEdge(40,i);
    }
    for(int i = 64;i<68;i++){
         if(i==64)
        continue;
       this.g.addEdge(40,i);
    }
    // vertice 42 block 5
     for(int i=42;i<48;i++){
       this.g.addEdge(41,i);
    }
    for(int i = 53;i<138;i=i+12){
       this.g.addEdge(41,i);
    }
    for(int i = 52;i<56;i++){
      if(i==53)
        continue;
       this.g.addEdge(41,i);
    }
    for(int i = 64;i<68;i++){
         if(i==65)
        continue;
       this.g.addEdge(41,i);
    }
    // vertice 43 block 5
   for(int i=43;i<48;i++){
       this.g.addEdge(42,i);
    }
    for(int i = 54;i<139;i=i+12){
       this.g.addEdge(42,i);
    }
    for(int i = 52;i<56;i++){
      if(i==54)
        continue;
       this.g.addEdge(42,i);
    }
    for(int i = 64;i<68;i++){
         if(i==66)
        continue;
       this.g.addEdge(42,i);
    }
    //vertice 44 block 5
    for(int i=44;i<48;i++){
       this.g.addEdge(43,i);
    }
    for(int i = 55;i<140;i=i+12){
       this.g.addEdge(43,i);
    }
    for(int i = 52;i<56;i++){
      if(i==55)
        continue;
       this.g.addEdge(43,i);
    }
    for(int i = 64;i<68;i++){
         if(i==67)
        continue;
       this.g.addEdge(43,i);
    }
    //vertice 45 block 6
      for(int i=45;i<48;i++){
       this.g.addEdge(44,i);
    }
    for(int i = 56;i<141;i=i+12){
       this.g.addEdge(44,i);
    }
    for(int i = 56;i<60;i++){
      if(i==56)
        continue;
       this.g.addEdge(44,i);
    }
    for(int i = 68;i<72;i++){
         if(i==68)
        continue;
       this.g.addEdge(44,i);
    }
    //vertice 46 block 6
     for(int i=46;i<48;i++){
       this.g.addEdge(45,i);
    }
    for(int i = 57;i<142;i=i+12){
       this.g.addEdge(45,i);
    }
    for(int i = 56;i<60;i++){
      if(i==57)
        continue;
       this.g.addEdge(45,i);
    }
    for(int i = 68;i<72;i++){
         if(i==69)
        continue;
       this.g.addEdge(45,i);
    }
    // vertice 47 block 6
      for(int i=47;i<48;i++){
       this.g.addEdge(46,i);
    }
    for(int i = 58;i<143;i=i+12){
       this.g.addEdge(46,i);
    }
    for(int i = 56;i<60;i++){
      if(i==58)
        continue;
       this.g.addEdge(46,i);
    }
    for(int i = 68;i<72;i++){
         if(i==70)
        continue;
       this.g.addEdge(46,i);
    }
    // vertice 48 block 6
    for(int i = 59;i<144;i=i+12){
       this.g.addEdge(47,i);
    }
    for(int i = 56;i<60;i++){
      if(i==59)
        continue;
       this.g.addEdge(47,i);
    }
    for(int i = 68;i<72;i++){
         if(i==71)
        continue;
       this.g.addEdge(47,i);
    }
    //vertice 49 block 4
      for(int i=49;i<60;i++){
       this.g.addEdge(48,i);
    }
    for(int i = 60;i<133;i=i+12){
       this.g.addEdge(48,i);
    }
    
    for(int i = 60;i<64;i++){
         if(i==60)
        continue;
       this.g.addEdge(48,i);
    }
   //vertice 50 block 4
     for(int i=50;i<60;i++){
       this.g.addEdge(49,i);
    }
    for(int i = 61;i<134;i=i+12){
       this.g.addEdge(49,i);
    }
    
    for(int i = 60;i<64;i++){
         if(i==61)
        continue;
       this.g.addEdge(49,i);
    }
    // vertice 51 block 4
     for(int i=51;i<60;i++){
       this.g.addEdge(50,i);
    }
    for(int i = 62;i<135;i=i+12){
       this.g.addEdge(50,i);
    }
    
    for(int i = 60;i<64;i++){
         if(i==62)
        continue;
       this.g.addEdge(50,i);
    }
    // vertice 52 block 4
      for(int i=52;i<60;i++){
       this.g.addEdge(51,i);
    }
    for(int i = 63;i<136;i=i+12){
       this.g.addEdge(51,i);
    }
    
    for(int i = 60;i<64;i++){
         if(i==63)
        continue;
       this.g.addEdge(51,i);
    }
    // vertice 53 block 5
    for(int i=53;i<60;i++){
       this.g.addEdge(52,i);
    }
    for(int i = 64;i<137;i=i+12){
       this.g.addEdge(52,i);
    }
    
    for(int i = 64;i<68;i++){
         if(i==64)
        continue;
       this.g.addEdge(52,i);
    }
    // vertice 54 block 5
     for(int i=54;i<60;i++){
       this.g.addEdge(53,i);
    }
    for(int i = 65;i<138;i=i+12){
       this.g.addEdge(53,i);
    }
    
    for(int i = 64;i<68;i++){
         if(i==65)
        continue;
      this.g.addEdge(53,i);
    } 
    //vertice 55 block 5
       for(int i=55;i<60;i++){
       this.g.addEdge(54,i);
    }
    for(int i = 66;i<139;i=i+12){
       this.g.addEdge(54,i);
    }
    
    for(int i = 64;i<68;i++){
         if(i==66)
        continue;
      this.g.addEdge(54,i);
    } 
    //vertice 56 block 5
        for(int i=56;i<60;i++){
       this.g.addEdge(55,i);
    }
    for(int i = 67;i<140;i=i+12){
       this.g.addEdge(55,i);
    }
    
    for(int i = 64;i<68;i++){
         if(i==67)
        continue;
      this.g.addEdge(55,i);
    }
    // vertice 57 block 6
      for(int i=57;i<60;i++){
       this.g.addEdge(56,i);
    }
    for(int i = 68;i<141;i=i+12){
       this.g.addEdge(56,i);
    }
    
    for(int i = 68;i<72;i++){
         if(i==68)
        continue;
      this.g.addEdge(56,i);
    }
    // vertice 58 block 6
    for(int i=58;i<60;i++){
       this.g.addEdge(57,i);
    }
    for(int i = 69;i<142;i=i+12){
       this.g.addEdge(57,i);
    }
    
    for(int i = 68;i<72;i++){
         if(i==69)
        continue;
      this.g.addEdge(57,i);
    }
    // vertice 59 block 6
     for(int i=59;i<60;i++){
       this.g.addEdge(58,i);
    }
    for(int i = 70;i<143;i=i+12){
       this.g.addEdge(58,i);
    }
    
    for(int i = 68;i<72;i++){
         if(i==70)
        continue;
      this.g.addEdge(58,i);
    }
    //vertice 60 block 6
    for(int i=60;i<60;i++){
       this.g.addEdge(59,i);
    }
    for(int i = 71;i<144;i=i+12){
       this.g.addEdge(59,i);
    }
    
    for(int i = 68;i<72;i++){
         if(i==71)
        continue;
      this.g.addEdge(59,i);
    }
    // vertice 61 block 4
     for(int i=61;i<72;i++){
       this.g.addEdge(60,i);
    }
    for(int i = 72;i<134;i=i+12){
       this.g.addEdge(60,i);
    }
    //vertice 62 block 4
    for(int i=62;i<72;i++){
       this.g.addEdge(61,i);
    }
    for(int i = 73;i<135;i=i+12){
       this.g.addEdge(61,i);
    }
    //vertice 63 block 4
     for(int i=63;i<72;i++){
       this.g.addEdge(62,i);
    }
    for(int i = 74;i<136;i=i+12){
       this.g.addEdge(62,i);
    }
    //vertice 64 block 4
     for(int i=64;i<72;i++){
       this.g.addEdge(63,i);
    }
    for(int i = 75;i<137;i=i+12){
       this.g.addEdge(63,i);
    }
    //vertice 65 block 5
      for(int i=65;i<72;i++){
       this.g.addEdge(64,i);
    }
    for(int i = 76;i<138;i=i+12){
       this.g.addEdge(64,i);
    }
    //vertice 66 block 5
      for(int i=66;i<72;i++){
       this.g.addEdge(65,i);
    }
    for(int i = 77;i<139;i=i+12){
       this.g.addEdge(65,i);
    }
    //vertive 67 block 5
      for(int i=67;i<72;i++){
       this.g.addEdge(66,i);
    }
    for(int i = 78;i<140;i=i+12){
       this.g.addEdge(66,i);
    }
    //vertice 68 block 5
      for(int i=68;i<72;i++){
       this.g.addEdge(67,i);
    }
    for(int i = 79;i<141;i=i+12){
       this.g.addEdge(67,i);
    }
    //vertice 69 block 6
      for(int i=69;i<72;i++){
       this.g.addEdge(68,i);
    }
    for(int i = 80;i<142;i=i+12){
       this.g.addEdge(68,i);
    }
    //vertice 70 block 6
      for(int i=70;i<72;i++){
       this.g.addEdge(69,i);
    }
    for(int i = 81;i<143;i=i+12){
       this.g.addEdge(69,i);
    }
    //vertice 71 block 6
      for(int i=71;i<72;i++){
       this.g.addEdge(70,i);
    }
    for(int i = 82;i<144;i=i+12){
       this.g.addEdge(70,i);
    }
    //vertice 72 block 6

    for(int i = 83;i<145;i=i+12){
       this.g.addEdge(71,i);
    }
    // vertice 73 block 7
     for(int i=73;i<84;i++){
       this.g.addEdge(72,i);
    }
    for(int i = 84;i<133;i=i+12){
       this.g.addEdge(72,i);
    }
    for(int i = 84;i<88;i++){
      if(i==84)
        continue;
       this.g.addEdge(72,i);
    }
    for(int i = 96;i<100;i++){
         if(i==96)
        continue;
       this.g.addEdge(72,i);
     }
     //vertice 74 block 7
      for(int i=74;i<84;i++){
       this.g.addEdge(73,i);
    }
    for(int i = 85;i<134;i=i+12){
       this.g.addEdge(73,i);
    }
    for(int i = 84;i<88;i++){
      if(i==85)
        continue;
       this.g.addEdge(73,i);
    }
    for(int i = 96;i<100;i++){
         if(i==97)
        continue;
       this.g.addEdge(73,i);
     }
     //vertice 75 block 7
      for(int i=75;i<84;i++){
       this.g.addEdge(74,i);
    }
    for(int i = 86;i<135;i=i+12){
       this.g.addEdge(74,i);
    }
    for(int i = 84;i<88;i++){
      if(i==86)
        continue;
       this.g.addEdge(74,i);
    }
    for(int i = 96;i<100;i++){
         if(i==98)
        continue;
       this.g.addEdge(74,i);
     }
     //vertice 76 block 7
      for(int i=76;i<84;i++){
       this.g.addEdge(75,i);
    }
    for(int i = 87;i<136;i=i+12){
       this.g.addEdge(75,i);
    }
    for(int i = 84;i<88;i++){
      if(i==87)
        continue;
       this.g.addEdge(75,i);
    }
    for(int i = 96;i<100;i++){
         if(i==99)
        continue;
       this.g.addEdge(75,i);
     }
     //vertice 77 block 8
    for(int i=77;i<84;i++){
       this.g.addEdge(76,i);
    }
    for(int i = 88;i<137;i=i+12){
       this.g.addEdge(76,i);
    }
    for(int i = 88;i<92;i++){
      if(i==88)
        continue;
       this.g.addEdge(76,i);
    }
    for(int i = 100;i<104;i++){
         if(i==100)
        continue;
       this.g.addEdge(76,i);
     }
     //vertice 78 block 8
    for(int i=78;i<84;i++){
       this.g.addEdge(77,i);
    }
    for(int i = 89;i<138;i=i+12){
       this.g.addEdge(77,i);
    }
    for(int i = 88;i<92;i++){
      if(i==89)
        continue;
       this.g.addEdge(77,i);
    }
    for(int i = 100;i<104;i++){
         if(i==101)
        continue;
       this.g.addEdge(77,i);
     }
     //vertice 79 block 8
     for(int i=79;i<84;i++){
       this.g.addEdge(78,i);
    }
    for(int i = 90;i<139;i=i+12){
       this.g.addEdge(78,i);
    }
    for(int i = 88;i<92;i++){
      if(i==90)
        continue;
       this.g.addEdge(78,i);
    }
    for(int i = 100;i<104;i++){
         if(i==102)
        continue;
       this.g.addEdge(78,i);
     }
     //vertice 80 block 8
      for(int i=80;i<84;i++){
       this.g.addEdge(79,i);
    }
    for(int i = 91;i<140;i=i+12){
       this.g.addEdge(79,i);
    }
    for(int i = 88;i<92;i++){
      if(i==91)
        continue;
       this.g.addEdge(79,i);
    }
    for(int i = 100;i<104;i++){
         if(i==103)
        continue;
       this.g.addEdge(79,i);
     }
     //vertice 81 block 9
       for(int i=81;i<84;i++){
       this.g.addEdge(80,i);
    }
    for(int i = 92;i<141;i=i+12){
       this.g.addEdge(80,i);
    }
    for(int i = 92;i<96;i++){
      if(i==92)
        continue;
       this.g.addEdge(80,i);
    }
    for(int i = 104;i<108;i++){
         if(i==104)
        continue;
       this.g.addEdge(80,i);
     }
     //vertice 82 block 9
     for(int i=82;i<84;i++){
       this.g.addEdge(81,i);
    }
    for(int i = 93;i<142;i=i+12){
       this.g.addEdge(81,i);
    }
    for(int i = 92;i<96;i++){
      if(i==93)
        continue;
       this.g.addEdge(81,i);
    }
    for(int i = 104;i<108;i++){
         if(i==105)
        continue;
       this.g.addEdge(81,i);
     }
     //vertice 83 block 9 
     for(int i=83;i<84;i++){
       this.g.addEdge(82,i);
    }
    for(int i = 94;i<143;i=i+12){
       this.g.addEdge(82,i);
    }
    for(int i = 92;i<96;i++){
      if(i==94)
        continue;
       this.g.addEdge(82,i);
    }
    for(int i = 104;i<108;i++){
         if(i==106)
        continue;
       this.g.addEdge(82,i);
     }
     //vertice 84 block 9
     for(int i=84;i<84;i++){
       this.g.addEdge(83,i);
    }
    for(int i = 95;i<144;i=i+12){
       this.g.addEdge(83,i);
    }
    for(int i = 92;i<96;i++){
      if(i==95)
        continue;
       this.g.addEdge(83,i);
    }
    for(int i = 104;i<108;i++){
         if(i==107)
        continue;
       this.g.addEdge(83,i);
     }
     //vertice 85 block 7
      for(int i=85;i<96;i++){
       this.g.addEdge(84,i);
    }
    for(int i = 96;i<133;i=i+12){
       this.g.addEdge(84,i);
    }
    
    for(int i = 96;i<100;i++){
         if(i==96)
        continue;
       this.g.addEdge(84,i);
     }
     // vertice 86 block 7
      for(int i=86;i<96;i++){
       this.g.addEdge(85,i);
    }
    for(int i = 97;i<134;i=i+12){
       this.g.addEdge(85,i);
    }
    
    for(int i = 96;i<100;i++){
         if(i==97)
        continue;
       this.g.addEdge(85,i);
     }
     //vertice 87 block 7
    for(int i=87;i<96;i++){
       this.g.addEdge(86,i);
    }
    for(int i = 98;i<135;i=i+12){
       this.g.addEdge(86,i);
    }
    
    for(int i = 96;i<100;i++){
         if(i==98)
        continue;
       this.g.addEdge(86,i);
     }
     //vertice 88 block 7
    for(int i=88;i<96;i++){
       this.g.addEdge(87,i);
    }
    for(int i = 99;i<136;i=i+12){
       this.g.addEdge(87,i);
    }
    
    for(int i = 96;i<100;i++){
         if(i==99)
        continue;
       this.g.addEdge(87,i);
     }
     //vertice 89 block 8
      for(int i=89;i<96;i++){
       this.g.addEdge(88,i);
    }
    for(int i = 100;i<137;i=i+12){
       this.g.addEdge(88,i);
    }
    
    for(int i = 100;i<104;i++){
         if(i==100)
        continue;
       this.g.addEdge(88,i);
     }
     //vertice 90 block 8
     for(int i=90;i<96;i++){
       this.g.addEdge(89,i);
    }
    for(int i = 101;i<138;i=i+12){
       this.g.addEdge(89,i);
    }
    
    for(int i = 100;i<104;i++){
         if(i==101)
        continue;
       this.g.addEdge(89,i);
     }
     //vertice 91 block 8
        for(int i=91;i<96;i++){
       this.g.addEdge(90,i);
    }
    for(int i = 102;i<139;i=i+12){
       this.g.addEdge(90,i);
    }
    
    for(int i = 100;i<104;i++){
         if(i==102)
        continue;
       this.g.addEdge(90,i);
     }
     //vertice 92 block 8
     for(int i=92;i<96;i++){
       this.g.addEdge(91,i);
    }
    for(int i = 103;i<140;i=i+12){
       this.g.addEdge(91,i);
    }
    
    for(int i = 100;i<104;i++){
         if(i==103)
        continue;
       this.g.addEdge(91,i);
     }
     //vertice 93 block 9
     for(int i=93;i<96;i++){
       this.g.addEdge(92,i);
    }
    for(int i = 104;i<141;i=i+12){
       this.g.addEdge(92,i);
    }
    
    for(int i = 104;i<108;i++){
         if(i==104)
        continue;
       this.g.addEdge(92,i);
     }
     //vertice 94 block 9
     for(int i=94;i<96;i++){
       this.g.addEdge(93,i);
    }
    for(int i = 105;i<142;i=i+12){
       this.g.addEdge(93,i);
    }
    
    for(int i = 104;i<108;i++){
         if(i==105)
        continue;
       this.g.addEdge(93,i);
     }
     //vertice 95 block 9
     for(int i=95;i<96;i++){
       this.g.addEdge(94,i);
    }
    for(int i = 106;i<143;i=i+12){
       this.g.addEdge(94,i);
    }
    
    for(int i = 104;i<108;i++){
         if(i==106)
        continue;
       this.g.addEdge(94,i);
     }
     //vertice 96 block 9

    for(int i = 107;i<144;i=i+12){
       this.g.addEdge(95,i);
    }
    
    for(int i = 104;i<108;i++){
         if(i==107)
        continue;
       this.g.addEdge(95,i);
     }
     //vertice 97 block 7
     for(int i=97;i<108;i++){
       this.g.addEdge(96,i);
    }
    for(int i = 108;i<133;i=i+12){
       this.g.addEdge(96,i);
    }
    //vertice 98 block 7
     for(int i=98;i<108;i++){
       this.g.addEdge(97,i);
    }
    for(int i = 109;i<134;i=i+12){
       this.g.addEdge(97,i);
    }
    //vertice 99 block 7
    for(int i=99;i<108;i++){
       this.g.addEdge(98,i);
    }
    for(int i = 110;i<135;i=i+12){
       this.g.addEdge(98,i);
    }
    //vertice 100 block 7
     for(int i=100;i<108;i++){
       this.g.addEdge(99,i);
    }
    for(int i = 111;i<136;i=i+12){
       this.g.addEdge(99,i);
    }
    //vertice 101 block 8
    for(int i=101;i<108;i++){
       this.g.addEdge(100,i);
    }
    for(int i = 112;i<137;i=i+12){
       this.g.addEdge(100,i);
    }
    //vertice 102 block 8
    for(int i=102;i<108;i++){
       this.g.addEdge(101,i);
    }
    for(int i = 113;i<138;i=i+12){
       this.g.addEdge(101,i);
    }
    //vertice 103 block 8
    for(int i=103;i<108;i++){
       this.g.addEdge(102,i);
    }
    for(int i = 114;i<139;i=i+12){
       this.g.addEdge(102,i);
    }
    //vertice 104 block 8
      for(int i=104;i<108;i++){
       this.g.addEdge(103,i);
    }
    for(int i = 115;i<140;i=i+12){
       this.g.addEdge(103,i);
    }
    //vertice 105 block 9
    for(int i=105;i<108;i++){
       this.g.addEdge(104,i);
    }
    for(int i = 116;i<141;i=i+12){
       this.g.addEdge(104,i);
    }
    //verticec 106 block 9
     for(int i=106;i<108;i++){
       this.g.addEdge(105,i);
    }
    for(int i = 117;i<142;i=i+12){
       this.g.addEdge(105,i);
    }
    //vertice 107 block 9
    for(int i=107;i<108;i++){
       this.g.addEdge(106,i);
    }
    for(int i = 118;i<143;i=i+12){
       this.g.addEdge(106,i);
    }
    //vertice 108 block 9
    for(int i = 119;i<144;i=i+12){
       this.g.addEdge(107,i);
    }
    //vertice 109 block 10
    for(int i=109;i<120;i++){
       this.g.addEdge(108,i);
    }
    for(int i = 120;i<133;i=i+12){
       this.g.addEdge(108,i);
    }
    for(int i = 120;i<124;i++){
      if(i==120)
        continue;
       this.g.addEdge(108,i);
    }
    for(int i = 132;i<136;i++){
         if(i==132)
        continue;
       this.g.addEdge(108,i);
     }
     //vertice 110 block 10
    for(int i=110;i<120;i++){
       this.g.addEdge(109,i);
    }
    for(int i = 121;i<134;i=i+12){
       this.g.addEdge(109,i);
    }
    for(int i = 120;i<124;i++){
      if(i==121)
        continue;
       this.g.addEdge(109,i);
    }
    for(int i = 132;i<136;i++){
         if(i==133)
        continue;
       this.g.addEdge(109,i);
     }
     //verticce 111 block 10
     for(int i=111;i<120;i++){
       this.g.addEdge(110,i);
    }
    for(int i = 122;i<135;i=i+12){
       this.g.addEdge(110,i);
    }
    for(int i = 120;i<124;i++){
      if(i==122)
        continue;
       this.g.addEdge(110,i);
    }
    for(int i = 132;i<136;i++){
         if(i==134)
        continue;
       this.g.addEdge(110,i);
     }
     //vertice 112 block 10
    for(int i=112;i<120;i++){
       this.g.addEdge(111,i);
    }
    for(int i = 123;i<136;i=i+12){
       this.g.addEdge(111,i);
    }
    for(int i = 120;i<124;i++){
      if(i==123)
        continue;
       this.g.addEdge(111,i);
    }
    for(int i = 132;i<136;i++){
         if(i==135)
        continue;
       this.g.addEdge(111,i);
     }
     //vertice 113 block 11
    for(int i=113;i<120;i++){
       this.g.addEdge(112,i);
    }
    for(int i = 124;i<137;i=i+12){
       this.g.addEdge(112,i);
    }
    for(int i = 124;i<128;i++){
      if(i==124)
        continue;
       this.g.addEdge(112,i);
    }
    for(int i = 136;i<140;i++){
         if(i==136)
        continue;
       this.g.addEdge(112,i);
     }
     //vertice 114 block 11
     for(int i=114;i<120;i++){
       this.g.addEdge(113,i);
    }
    for(int i = 125;i<138;i=i+12){
       this.g.addEdge(113,i);
    }
    for(int i = 124;i<128;i++){
      if(i==125)
        continue;
       this.g.addEdge(113,i);
    }
    for(int i = 136;i<140;i++){
         if(i==137)
        continue;
       this.g.addEdge(113,i);
     }
     //vertice 115 block 11
    for(int i=115;i<120;i++){
       this.g.addEdge(114,i);
    }
    for(int i = 126;i<139;i=i+12){
       this.g.addEdge(114,i);
    }
    for(int i = 124;i<128;i++){
      if(i==126)
        continue;
       this.g.addEdge(114,i);
    }
    for(int i = 136;i<140;i++){
         if(i==138)
        continue;
       this.g.addEdge(114,i);
     }
     //vertice 116 block 11
     for(int i=116;i<120;i++){
       this.g.addEdge(115,i);
    }
    for(int i = 127;i<140;i=i+12){
       this.g.addEdge(115,i);
    }
    for(int i = 124;i<128;i++){
      if(i==127)
        continue;
       this.g.addEdge(115,i);
    }
    for(int i = 136;i<140;i++){
         if(i==139)
        continue;
       this.g.addEdge(115,i);
     }
     //vertice 117 block 12
    for(int i=117;i<120;i++){
       this.g.addEdge(116,i);
    }
    for(int i = 128;i<141;i=i+12){
       this.g.addEdge(116,i);
    }
    for(int i = 128;i<132;i++){
      if(i==128)
        continue;
       this.g.addEdge(116,i);
    }
    for(int i = 140;i<144;i++){
         if(i==140)
        continue;
       this.g.addEdge(116,i);
     }
     //vertice 118 block 12
    for(int i=118;i<120;i++){
       this.g.addEdge(117,i);
    }
    for(int i = 129;i<142;i=i+12){
       this.g.addEdge(117,i);
    }
    for(int i = 128;i<132;i++){
      if(i==129)
        continue;
       this.g.addEdge(117,i);
    }
    for(int i = 140;i<144;i++){
         if(i==141)
        continue;
       this.g.addEdge(117,i);
     }
     //vertice 119 block 12
     for(int i=119;i<120;i++){
       this.g.addEdge(118,i);
    }
    for(int i = 130;i<143;i=i+12){
       this.g.addEdge(118,i);
    }
    for(int i = 128;i<132;i++){
      if(i==130)
        continue;
       this.g.addEdge(118,i);
    }
    for(int i = 140;i<144;i++){
         if(i==142)
        continue;
       this.g.addEdge(118,i);
     }
     //vertice 120 block 12

    for(int i = 131;i<144;i=i+12){
       this.g.addEdge(119,i);
    }
    for(int i = 128;i<132;i++){
      if(i==131)
        continue;
       this.g.addEdge(119,i);
    }
    for(int i = 140;i<144;i++){
         if(i==143)
        continue;
       this.g.addEdge(119,i);
     }
     //vertice 121 block 10
    for(int i=121;i<132;i++){
       this.g.addEdge(120,i);
    }
    for(int i = 132;i<133;i=i+12){
       this.g.addEdge(120,i);
    }
    
    for(int i = 132;i<136;i++){
         if(i==132)
        continue;
       this.g.addEdge(120,i);
     }
     //vertice 122 block 10
     for(int i=122;i<132;i++){
       this.g.addEdge(121,i);
    }
    for(int i = 133;i<134;i=i+12){
       this.g.addEdge(121,i);
    }
    
    for(int i = 132;i<136;i++){
         if(i==133)
        continue;
       this.g.addEdge(121,i);
     }
     //vertice 123 block 10
    for(int i=123;i<132;i++){
       this.g.addEdge(122,i);
    }
    for(int i = 134;i<135;i=i+12){
       this.g.addEdge(122,i);
    }
    
    for(int i = 132;i<136;i++){
         if(i==134)
        continue;
       this.g.addEdge(122,i);
     }
     //vertice 124 block 10
      for(int i=124;i<132;i++){
       this.g.addEdge(123,i);
    }
    for(int i = 135;i<136;i=i+12){
       this.g.addEdge(123,i);
    }
    
    for(int i = 132;i<136;i++){
         if(i==135)
        continue;
       this.g.addEdge(123,i);
     }
     //vertice 125 block 11
      for(int i=125;i<132;i++){
       this.g.addEdge(124,i);
    }
    for(int i = 136;i<137;i=i+12){
       this.g.addEdge(124,i);
    }
    
    for(int i = 136;i<140;i++){
         if(i==136)
        continue;
       this.g.addEdge(124,i);
     }
     //vertice 126 block 11
    for(int i=126;i<132;i++){
       this.g.addEdge(125,i);
    }
    for(int i = 137;i<138;i=i+12){
       this.g.addEdge(125,i);
    }
    
    for(int i = 136;i<140;i++){
         if(i==137)
        continue;
       this.g.addEdge(125,i);
     }
     //vertice 127 block 11
     for(int i=127;i<132;i++){
       this.g.addEdge(126,i);
    }
    for(int i = 138;i<139;i=i+12){
       this.g.addEdge(126,i);
    }
    
    for(int i = 136;i<140;i++){
         if(i==138)
        continue;
       this.g.addEdge(126,i);
     }
     //vertice 128 block 11
     for(int i=128;i<132;i++){
       this.g.addEdge(127,i);
    }
    for(int i = 139;i<140;i=i+12){
       this.g.addEdge(127,i);
    }
    
    for(int i = 136;i<140;i++){
         if(i==139)
        continue;
       this.g.addEdge(127,i);
     }
     //vertice 129 block 12
        for(int i=129;i<132;i++){
       this.g.addEdge(128,i);
    }
    for(int i = 140;i<141;i=i+12){
       this.g.addEdge(128,i);
    }
    
    for(int i = 140;i<144;i++){
         if(i==140)
        continue;
       this.g.addEdge(128,i);
     }
     //vertice 130 block 12
     for(int i=130;i<132;i++){
       this.g.addEdge(129,i);
    }
    for(int i = 141;i<142;i=i+12){
       this.g.addEdge(129,i);
    }
    
    for(int i = 140;i<144;i++){
         if(i==141)
        continue;
       this.g.addEdge(129,i);
     }
     //vertice 131 block 12
      for(int i=131;i<132;i++){
       this.g.addEdge(130,i);
    }
    for(int i = 142;i<143;i=i+12){
       this.g.addEdge(130,i);
    }
    
    for(int i = 140;i<144;i++){
         if(i==142)
        continue;
       this.g.addEdge(130,i);
     }
     //vertice 132 block 12
     for(int i = 143;i<144;i=i+12){
       this.g.addEdge(131,i);
    }
    
    for(int i = 140;i<144;i++){
         if(i==143)
        continue;
       this.g.addEdge(131,i);
     }
     //vertice 133 block 10
      for(int i=133;i<144;i++){
       this.g.addEdge(132,i);
    }
    //vertice 134 block 10
    for(int i=134;i<144;i++){
       this.g.addEdge(133,i);
    }
    //vertice 135 block 10
     for(int i=135;i<144;i++){
       this.g.addEdge(134,i);
    }
    //vertice 136 block 10
      for(int i=136;i<144;i++){
       this.g.addEdge(135,i);
    }
    //vertice 137 block 11
     for(int i=137;i<144;i++){
       this.g.addEdge(136,i);
    }
    //vertice 138 block 11
     for(int i=138;i<144;i++){
       this.g.addEdge(137,i);
    }
    //vertice 139 block 11
    for(int i=139;i<144;i++){
       this.g.addEdge(138,i);
    }
    //vertice 140 block 11
  for(int i=140;i<144;i++){
       this.g.addEdge(139,i);
    }
    //vertice 141 block 12
     for(int i=141;i<144;i++){
       this.g.addEdge(140,i);
    }
    //vertice 142 block 12
    for(int i=142;i<144;i++){
       this.g.addEdge(141,i);
    }
    //vertice 143 block 12
    for(int i=143;i<144;i++){
       this.g.addEdge(142,i);
    }
    //System.out.print(temp[0][0]);
     /*

     System.out.println(this.g.getListAdj(136));
     System.out.println(this.g.getListAdj(137));
     System.out.println(this.g.getListAdj(138));
     System.out.println(this.g.getListAdj(139));
     System.out.println(this.g.getListAdj(140));  
     System.out.println(this.g.getListAdj(141));
     System.out.println(this.g.getListAdj(142)); 
     System.out.println(this.g.getListAdj(143));
     */    
    }
    
    // Assigns colors (starting from 0) to all vertices and
    // prints the assignment of colors
    void greedyColoring(String output_name)
    { 
		    int black   =   1;
        int blue    =   2;
        int brown   =   3;
        int green   =   4;
        int orange  =   5;
        int violet  =   6;
        int red     =   7;
        int pink    =   8;
        int yellow  =   9;
        int gray    =   10;
        int purple  =   11;
        int magenta =   12;  
        Solve();
      // this.g.printGraph(array);
         //System.out.println(array[2][3]);
        
           
        
       writeSolvePuzzle(output_name);
    }
   public  boolean Solve(){
      for(int row=0;row<12;row++)
      {
        for(int col=0;col<12;col++)
        {
          if(this.array[row][col] == 0)
          {
            for(int num = 1;num<=12;num++)
             {
              if(isSafe(row,col,num))
              {
                this.array[row][col]=num;
                if(Solve())
                {
                  return true;
                }
                else
                {
                  this.array[row][col] =0;
                }
              }
             }
             return false; 
          }
        }
      }
      return true;
   }


   public boolean containRow(int row , int num){
    for(int i = 0;i<12;i++){
      if(array[row][i] == num)
        return true;
    }
    return false;
   }
   public  boolean containCol(int col ,int num){
    for(int i=0;i<12;i++){
      if(array[i][col]==num)
        return true;
    }
    return false;
   }
   public  boolean containBox(int row,int col,int num){
    int r=row - row%3;
    int c= col -col%4;
    for(int i=r;i < r+3;i++)
    {
      for(int j= c;j<c+4;j++)
      {
        if(array[i][j]==num)
          return true;  
      }
    }
    return false;
   }
   public  boolean isSafe(int row,int col,int num){
    return !(containRow(row,num) || containCol(col,num) || containBox(row,col,num));
   }


    public void writeSolvePuzzle(String output_name)
    {
        try{
                        fileOut = new FileWriter(output_name); 
                       // write code here
						           for(int i=0;i<12;i++){
                          for(int j = 0; j < 12;j++){
                                fileOut.write(String.valueOf(this.array[i][j]));
                            }
                             fileOut.write("\n");
                        }
					             
                        fileOut.close();
                        
              }
              catch(IOException e)
              {
                
              }
    }
    
    public static void main(String args[])
    {
        SudokuSolver g1 = new SudokuSolver(144, args[0]);
		   
		    

        g1.greedyColoring(args[1]);
    }
}
// This code is contributed by Anh Vo 
