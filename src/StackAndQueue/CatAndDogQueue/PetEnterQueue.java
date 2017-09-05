package StackAndQueue.CatAndDogQueue;

import java.util.Queue;

/**
 * Created by ShadowMoon on 2017/8/26.
 */
public class PetEnterQueue{
    private Pet pet;
    private long Count;

    public PetEnterQueue(Pet pet, long count) {
        this.pet = pet;
        Count = count;
    }

    public Pet getPet(){
        return this.pet;
    }

    public Long getCount() {
        return Count;
    }

    public String getPetType(){
        return this.pet.getPetType();
    }
}
