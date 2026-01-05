package com.rosokha.task4;

import java.util.ArrayList;
import java.util.List;

public class Guild<T extends GameCharacter> {
    private List<T> members;

    public Guild(){
        members = new ArrayList<>();
    }

    public void add(T character){
        this.members.add(character);
    }

    public void triggerEveryoneAttack(){
        members.forEach(GameCharacter::attack);
    }
}
