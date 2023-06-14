package com.ohgiraffers.section02.annotation.subsection03.collection;

import com.ohgiraffers.section02.common.Pokemon;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("fieldCollection")
public class PokemonBattleField {
    private List<Pokemon> pokemons;

    public PokemonBattleField(List<Pokemon> pokemons){
        this.pokemons =pokemons;
    }

    public void fight(){
        for (Pokemon pokemon : pokemons){
            pokemon.attack();
        }
    }
}
