package com.example.project;
import java.io.BufferedReader;
import java.io.IOExeption;
import java.io.InputStreamReader;
import java.util.Arraylist;

//Looks really good! Complete enough I would say and you obviously put a lot of effort into it so good job!

public class Cube {

	
	String[][] cube = {
		{
		"r","r","r",
		"r","r","r",
		"r","r","r",
		},{
		"b","b","b",
		"b","b","b",
		"b","b","b",
		},{
		"o","o","o",
		"o","o","o",
		"o","o","o",
		},{
		"g","g","g",
		"g","g","g",
		"g","g","g",
		},{
		"y","y","y",
		"y","y","y",
		"y","y","y",
		},{
		"w","w","w",
		"w","w","w",
		"w","w","w",
		}
	};
	
class edgedFace {
	public int current_face;
	int [] edge1 = new int[4]; //index 0 is the face, 1-3 are the elements of the face [1, 0, 1, 2]
	int [] edge2 = new int[4]; //             											[0, 0, 1, 2]
	int [] edge3 = new int[4];
	int [] edge4 = new int[4];

	public edgedFace(int face){
		current_face = face;

		switch (face) {
			case 0:
			edge1[0] = 1;
			edge1[1] = 2;
			edge1[2] = 5;
			edge1[3] = 8;

			edge2[0] = 4;
			edge2[1] = 2;
			edge2[2] = 5;
			edge2[3] = 8;
			
			edge3[0] = 3;
			edge3[1] = 0;
			edge3[2] = 3;
			edge3[3] = 6;

			edge4[0] = 5;			
			edge4[1] = 2;
			edge4[2] = 5;
			edge4[3] = 8;



			break;
			case 1:
			edge1[0] = 2;
			edge1[1] = 2;
			edge1[2] = 5;
			edge1[3] = 8;

			edge2[0] = 4;
			edge2[1] = 6;
			edge2[2] = 7;
			edge2[3] = 8;
			
			edge3[0] = 0;
			edge3[1] = 0;
			edge3[2] = 3;
			edge3[3] = 6;

			edge4[0] = 5;			
			edge4[1] = 0;
			edge4[2] = 1;
			edge4[3] = 2;
				
			break;
			case 2:			
			edge1[0] = 3;
			edge1[1] = 2;
			edge1[2] = 5;
			edge1[3] = 8;

			edge2[0] = 4;
			edge2[1] = 0;
			edge2[2] = 3;
			edge2[3] = 6;
			
			edge3[0] = 1;
			edge3[1] = 0;
			edge3[2] = 3;
			edge3[3] = 6;

			edge4[0] = 5;			
			edge4[1] = 0;
			edge4[2] = 3;
			edge4[3] = 6;	

			break;
			case 3:
			edge1[0] = 0;
			edge1[1] = 2;
			edge1[2] = 5;
			edge1[3] = 8;

			edge2[0] = 4;
			edge2[1] = 0;
			edge2[2] = 1;
			edge2[3] = 2;
			
			edge3[0] = 2;
			edge3[1] = 0;
			edge3[2] = 3;
			edge3[3] = 6;

			edge4[0] = 5;			
			edge4[1] = 0;
			edge4[2] = 3;
			edge4[3] = 6;
				
			break;
			case 4:
			edge1[0] = 2;
			edge1[1] = 0;
			edge1[2] = 1;
			edge1[3] = 2;

			edge2[0] = 1;
			edge2[1] = 0;
			edge2[2] = 1;
			edge2[3] = 2;
			
			edge3[0] = 3;
			edge3[1] = 2;
			edge3[2] = 1;
			edge3[3] = 0;

			edge4[0] = 0;			
			edge4[1] = 2;
			edge4[2] = 1;
			edge4[3] = 0;
				
			break;
			case 5:
			edge1[0] = 0;
			edge1[1] = 6;
			edge1[2] = 7;
			edge1[3] = 8;

			edge2[0] = 3;
			edge2[1] = 6;
			edge2[2] = 7;
			edge2[3] = 8;
			
			edge3[0] = 2;
			edge3[1] = 6;
			edge3[2] = 7;
			edge3[3] = 8;

			edge4[0] = 1;			
			edge4[1] = 6;
			edge4[2] = 7;
			edge4[3] = 8;
				
			break;
		}
	}
}

public void turnFace(int index, String direction){
edgedFace eface = new edgedFace(index);

String[][] copy = new String[6][9];

for (int i = 0; i<6; i++) {
	for (int j = 0; j<9; j++){
		copy[i][j] = cube[i][j];
	}
}

switch (direction) {
	case "c":
		 cube[eface.current_face][0] = copy[eface.current_face][2];
		 cube[eface.current_face][1] = copy[eface.current_face][5];
		 cube[eface.current_face][2] = copy[eface.current_face][8];
		 cube[eface.current_face][3] = copy[eface.current_face][1];
		 cube[eface.current_face][5] = copy[eface.current_face][7];
		 cube[eface.current_face][6] = copy[eface.current_face][0];
		 cube[eface.current_face][7] = copy[eface.current_face][3];
		 cube[eface.current_face][8] = copy[eface.current_face][6];

		 //edge1 Changed
		 cube[eface.edge1[0]][eface.edge1[1]] = copy[eface.edge4[0]][eface.edge4[1]];
		 cube[eface.edge1[0]][eface.edge1[2]] = copy[eface.edge4[0]][eface.edge4[2]];
		 cube[eface.edge1[0]][eface.edge1[3]] = copy[eface.edge4[0]][eface.edge4[3]];
		 //edge2 Changed
		 cube[eface.edge2[0]][eface.edge2[1]] = copy[eface.edge1[0]][eface.edge1[1]];
		 cube[eface.edge2[0]][eface.edge2[2]] = copy[eface.edge1[0]][eface.edge1[2]];
		 cube[eface.edge2[0]][eface.edge2[3]] = copy[eface.edge1[0]][eface.edge1[3]];
		 //edge3 Changed
		 cube[eface.edge3[0]][eface.edge3[1]] = copy[eface.edge2[0]][eface.edge2[1]];
		 cube[eface.edge3[0]][eface.edge3[2]] = copy[eface.edge2[0]][eface.edge2[2]];
		 cube[eface.edge3[0]][eface.edge3[3]] = copy[eface.edge2[0]][eface.edge2[3]];
		 //edge4 Changed
		 cube[eface.edge4[0]][eface.edge4[1]] = copy[eface.edge3[0]][eface.edge3[1]];
		 cube[eface.edge4[0]][eface.edge4[2]] = copy[eface.edge3[0]][eface.edge3[2]];
		 cube[eface.edge4[0]][eface.edge4[3]] = copy[eface.edge3[0]][eface.edge3[3]];


	break;
	case "cc":
	cube[eface.current_face][0] = copy[eface.current_face][6];
	cube[eface.current_face][1] = copy[eface.current_face][3];
	cube[eface.current_face][2] = copy[eface.current_face][0];
	cube[eface.current_face][3] = copy[eface.current_face][7];
	cube[eface.current_face][5] = copy[eface.current_face][1];
	cube[eface.current_face][6] = copy[eface.current_face][8];
	cube[eface.current_face][7] = copy[eface.current_face][5];
	cube[eface.current_face][8] = copy[eface.current_face][2];

	//edge1 Changed
	cube[eface.edge1[0]][eface.edge1[1]] = copy[eface.edge2[0]][eface.edge2[1]];
	cube[eface.edge1[0]][eface.edge1[2]] = copy[eface.edge2[0]][eface.edge2[2]];
	cube[eface.edge1[0]][eface.edge1[3]] = copy[eface.edge2[0]][eface.edge2[3]];
	//edge2 Changed
	cube[eface.edge2[0]][eface.edge2[1]] = copy[eface.edge3[0]][eface.edge3[1]];
	cube[eface.edge2[0]][eface.edge2[2]] = copy[eface.edge3[0]][eface.edge3[2]];
	cube[eface.edge2[0]][eface.edge2[3]] = copy[eface.edge3[0]][eface.edge3[3]];
	//edge3 Changed
	cube[eface.edge3[0]][eface.edge3[1]] = copy[eface.edge4[0]][eface.edge4[1]];
	cube[eface.edge3[0]][eface.edge3[2]] = copy[eface.edge4[0]][eface.edge4[2]];
	cube[eface.edge3[0]][eface.edge3[3]] = copy[eface.edge4[0]][eface.edge4[3]];
	//edge4 Changed
	cube[eface.edge4[0]][eface.edge4[1]] = copy[eface.edge1[0]][eface.edge1[1]];
	cube[eface.edge4[0]][eface.edge4[2]] = copy[eface.edge1[0]][eface.edge1[2]];
	cube[eface.edge4[0]][eface.edge4[3]] = copy[eface.edge1[0]][eface.edge1[3]];


	break;
}

}

	public void showCube (){
		int ind = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 3; j++){
				for (int k = 0; k < 3; k++){
					System.out.print(cube[i][ind++]);
				}
				System.out.println();
			}
			ind = 0;
			System.out.println();
		}

	}
		

	public static void main(final String[] args);
	throw IOExeption
	{
BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

Cube RubiksCube = new Cube();

boolean argsCheck = false;

if(args.length > 0){
	argsCheck = true;
}

boolean proceed = true;

while (proceed){
	String input;

	if (argsCheck){
		input = reader.readLine();
	} else {
		if(argsRunIndex == args.length){
			argsCheck = false;
			input = "s";
		}
		else {
			input = args(argsRunIndex);
			argsRunIndex++;
		}
	}
	switch(input){
		case "u":
		RubiksCube.turnFace(4, "c");
		RubiksCube.showCube();
		break;
		case "d":
		RubiksCube.turnFace(5, "c");
		RubiksCube.showCube();
		break;
		case "l":
		RubiksCube.turnFace(2, "c");
		RubiksCube.showCube();
		break;
		case "r":
		RubiksCube.turnFace(0, "c");
		RubiksCube.showCube();
		break;
		case "f":
		RubiksCube.turnFace(1, "c");
		RubiksCube.showCube();
		break;
		case "b":
		RubiksCube.turnFace(3, "c");
		RubiksCube.showCube();
		break;
		case "u'":
		RubiksCube.turnFace(4, "cc");
		RubiksCube.showCube();
		break;
		case "d'":
		RubiksCube.turnFace(5, "cc");
		RubiksCube.showCube();
		break;
		case "l'":
		RubiksCube.turnFace(2, "cc");
		RubiksCube.showCube();
		break;
		case "r'":
		RubiksCube.turnFace(0, "cc");
		RubiksCube.showCube();
		break;
		case "f'":
		RubiksCube.turnFace(1, "cc");
		RubiksCube.showCube();
		break;
		case "b'":
		RubiksCube.turnFace(3, "cc");
		RubiksCube.showCube();
		break;
		case "s":
		
		break;
		case "q":
		proceed = false;
		break;
	
	}
}
	}

}
