package StackAndQueue.CatAndDogQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ShadowMoon on 2017/8/26.
 */

//P10
public class CatDogQueue {
    private Queue<PetEnterQueue> catQueue;
    private Queue<PetEnterQueue> dogQueue;
    private long count;

    public CatDogQueue() {
        this.catQueue = new LinkedList<PetEnterQueue>();
        this.dogQueue = new LinkedList<PetEnterQueue>();
        this.count = 0;
    }

    public void add(Pet pet){
        if(pet.getPetType().equals("Cat")){
            this.catQueue.add(new PetEnterQueue(pet,this.count++));
        }else if(pet.getPetType().equals("Dog")) {
            this.dogQueue.add(new PetEnterQueue(pet,this.count++));
        }else {
            throw new RuntimeException("The Pet is neither Cat nor Dog.");
        }
    }

    public Pet pullAll(){
        if (!catQueue.isEmpty() && !dogQueue.isEmpty()){
            if (catQueue.peek().getCount() > dogQueue.peek().getCount()){
                return catQueue.poll().getPet();
            }else {
                return dogQueue.poll().getPet();
            }
        }else if (!catQueue.isEmpty()){
            return catQueue.poll().getPet();
        }else if (!dogQueue.isEmpty()){
            return dogQueue.poll().getPet();
        }else {
            throw new RuntimeException("The Queue is empty!");
        }
    }

    public Pet pullCat(){
        if (catQueue.isEmpty()){
            throw new RuntimeException("There is no Cat in the Queue!");
        }
        return catQueue.poll().getPet();
    }

    public Pet pullDog(){
        if (dogQueue.isEmpty()){
            throw new RuntimeException("There is no Dog in the Queue!");
        }
        return dogQueue.poll().getPet();
    }

    public boolean isEmpty(){
        return catQueue.isEmpty()  &&  dogQueue.isEmpty();
    }

    public boolean isDogEmpty(){
        return dogQueue.isEmpty();
    }

    public boolean isCatEmpty(){
        return catQueue.isEmpty();
    }
}
