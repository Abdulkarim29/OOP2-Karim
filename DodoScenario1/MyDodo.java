import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *
 * @author Sjaak Smetsers & Renske Smetsers-Weeda
 * @version 3.0 -- 20-01-2017
 */
public class MyDodo extends Dodo
{
    private int myNrOfEggsHatched;
    
    public MyDodo() {
        super(EAST);
        myNrOfEggsHatched = 0;
    }

    public void act() {
    }

    
    public void turnRight() {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    
    public void turn180() {
        turnRight();
        turnRight();
    }

    
    public void move() {
        if (canMove()) {
            step();
        } else {
            showError("I'm stuck!");
        }
    }

    
    public boolean canMove() {
        if (borderAhead()) {
            return false;
        } else if (fenceAhead()) {
            return false;
        } else {
            return true;
        }
    }

    
    public void hatchEgg() {
        if (onEgg()) {
            pickUpEgg();
            myNrOfEggsHatched++;
        } else {
            showError("There was no egg in this cell");
        }
    }

    
    public int getNrOfEggsHatched() {
        return myNrOfEggsHatched;
    }

   
    public void jump(int distance) {
        int nrStepsTaken = 0;

        while (nrStepsTaken < distance && canMove()) {
            move();
            nrStepsTaken++;
            System.out.println("moved " + nrStepsTaken);
        }

        if (nrStepsTaken < distance) {
            showError("Distance is too large");
        }
    }

    
    public void walkToWorldEdge() {
        while (!borderAhead()) {
            move();
        }

       
    }

    
    public boolean canLayEgg() {
        if (onEgg()) {
            return false;
        } else {
            return true;
        }
    }

    
    public boolean grainAhead() {
        if (!canMove()) {
            return false;
        }

        move();

        if (onGrain()) {
            turn180();
            move();
            turn180();
            return true;
        } else {
            turn180();
            move();
            turn180();
            return false;
        }
    }

    
    public void climbOverFence() {
        turnLeft();
        move();

        turnRight();
        move();
        move();

        turnRight();
        move();

        turnLeft();
    }
    
    public void gotoEgg(){
        while (!onEgg()){
        move();
        }
    
    }
    
    public void goBackToStartOfRowAndFaceBack(){
    turn180();
    while (!borderAhead()){
        move();
    
    }

    
    }
    
  public void walkToWorldEdgeClimbingOverFences() {
    while (!borderAhead()) {
        if (fenceAhead()) {
            climbOverFence();
        } else {
            move();
        }
    }
    
}
    
public void pickUpGainsAndPrintCoordinates(){
while (!borderAhead()) {
    if (onGrain()) {
        System.out.println("x: " + getX() + ", y: " + getY());
        pickUpGrain();
    }

    move();
}
if (onGrain()) {
        System.out.println("x: " + getX() + ", y: " + getY());
        pickUpGrain();
    }
}

public void stepOneCellBackwards(){
turn180();
move();
turn180();
}

public void walkToWayEdgeAndLayEgg() {
    while (!borderAhead()) {
        if (onNest() && canLayEgg()) {
            layEgg();
        }

        move();
    }

    if (onNest() && canLayEgg()) {
        layEgg();
    }
}

public void walkToNestClimbingOverFences() {
    while (!borderAhead()) {
        if (fenceAhead()) {
            climbOverFence();
        } else {
            move();
        }
        if (onNest() && canLayEgg()) {
        layEgg();
    }
        
    }

    if (onNest() && canLayEgg()) {
        layEgg();
    }
}

public void walkAroundFencedArea() {
    while (!onEgg()) {
        if (fenceAhead()) {
            turnLeft();
        } else {
            move();
            turnRight();
        }
    }
}
}