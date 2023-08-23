package com.envyful.api.reforged.pixelmon.sprite;

import com.pixelmonmod.pixelmon.api.pokemon.species.Species;
import com.pixelmonmod.pixelmon.api.pokemon.species.Stats;
import com.pixelmonmod.pixelmon.api.pokemon.species.gender.Gender;
import com.pixelmonmod.pixelmon.api.registries.PixelmonItems;
import net.minecraft.nbt.ByteTag;
import net.minecraft.nbt.ShortTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.world.item.ItemStack;

public class SpriteBuilder {

    private Species species;
    private Gender gender = Gender.MALE;
    private boolean shiny = false;

    private String nick = null;
    private Stats form = null;

    public SpriteBuilder() {}

    public SpriteBuilder species(Species species) {
        this.species = species;
        return this;
    }

    public SpriteBuilder gender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public SpriteBuilder shiny(boolean shiny) {
        this.shiny = shiny;
        return this;
    }

    public SpriteBuilder nick(String nick) {
        this.nick = nick;
        return this;
    }

    public SpriteBuilder form(Stats form) {
        this.form = form;
        return this;
    }

    public ItemStack build() {
        ItemStack itemStack = new ItemStack(PixelmonItems.pixelmon_sprite);
        itemStack.addTagElement("ndex", ShortTag.valueOf((short) this.species.getDex()));

        if (this.form != null) {
            itemStack.addTagElement("form", StringTag.valueOf(this.form.getName()));
        }

        itemStack.addTagElement("gender", ByteTag.valueOf((byte)this.gender.ordinal()));
        itemStack.addTagElement("palette", StringTag.valueOf(this.shiny ? "shiny" : "none"));

        if (this.nick != null && !this.nick.isEmpty()) {
            itemStack.addTagElement("Nickname", StringTag.valueOf(this.nick));
        }

        return itemStack;
    }
}
