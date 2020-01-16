package com.terraforged.core.world.terrain;

import com.terraforged.core.settings.Settings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Terrains {

    public final Terrain ocean;
    public final Terrain deepOcean;
    public final Terrain coast;
    public final Terrain beach;
    public final Terrain lake;
    public final Terrain river;
    public final Terrain riverBanks;
    public final Terrain badlands;
    public final Terrain steppe;
    public final Terrain plains;
    public final Terrain plateau;
    public final Terrain hills;
    public final Terrain dales;
    public final Terrain torridonian;
    public final Terrain mountains;
    public final Terrain volcano;
    public final Terrain volcanoPipe;
    public final List<Terrain> index;

    private Terrains(Mutable mutable) {
        List<Terrain> index = new ArrayList<>();
        Collections.addAll(
                index,
                ocean = mutable.ocean,
                deepOcean = mutable.deepOcean,
                coast = mutable.coast,
                beach = mutable.beach,
                lake = mutable.lake,
                river = mutable.river,
                torridonian = mutable.torridonian,
                riverBanks = mutable.riverbanks,
                badlands = mutable.badlands,
                plateau = mutable.plateau,
                steppe = mutable.steppe,
                plains = mutable.plains,
                hills = mutable.hills,
                dales = mutable.dales,
                mountains = mutable.mountains,
                volcano = mutable.volcanoes,
                volcanoPipe = mutable.volcanoPipe
        );
        this.index = Collections.unmodifiableList(index);
    }

    public int getId(Terrain landForm) {
        return landForm.getId();
    }

    public boolean overridesRiver(Terrain terrain) {
        return isOcean(terrain) || terrain == coast;
    }

    public boolean isOcean(Terrain terrain) {
        return terrain == ocean || terrain == deepOcean;
    }

    public boolean isRiver(Terrain terrain) {
        return terrain == river || terrain == riverBanks;
    }

    public static Terrains create(Settings settings) {
        Mutable terrain = new Mutable();
        terrain.ocean = Terrain.ocean(settings);
        terrain.deepOcean = Terrain.deepOcean(settings);
        terrain.coast = Terrain.coast(settings);
        terrain.beach = Terrain.beach(settings);
        terrain.lake = Terrain.lake(settings);
        terrain.river = Terrain.river(settings);
        terrain.riverbanks = Terrain.riverBank(settings);
        terrain.badlands = Terrain.badlands(settings);
        terrain.plateau = Terrain.plateau(settings);
        terrain.steppe = Terrain.steppe(settings);
        terrain.plains = Terrain.plains(settings);
        terrain.hills = Terrain.hills(settings);
        terrain.dales = Terrain.dales(settings);
        terrain.torridonian = Terrain.torridonian(settings);
        terrain.mountains = Terrain.mountains(settings);
        terrain.volcanoes = Terrain.volcano(settings);
        terrain.volcanoPipe = Terrain.volcanoPipe(settings);
        return terrain.create();
    }

    public static final class Mutable {
        public Terrain ocean = Terrain.NONE;
        public Terrain deepOcean = Terrain.NONE;
        public Terrain coast = Terrain.NONE;
        public Terrain beach = Terrain.NONE;
        public Terrain lake = Terrain.NONE;
        public Terrain river = Terrain.NONE;
        public Terrain riverbanks = Terrain.NONE;
        public Terrain badlands = Terrain.NONE;
        public Terrain plateau = Terrain.NONE;
        public Terrain steppe = Terrain.NONE;
        public Terrain plains = Terrain.NONE;
        public Terrain hills = Terrain.NONE;
        public Terrain dales = Terrain.NONE;
        public Terrain torridonian = Terrain.NONE;
        public Terrain mountains = Terrain.NONE;
        public Terrain volcanoes = Terrain.NONE;
        public Terrain volcanoPipe = Terrain.NONE;
        public Terrains create() {
            return new Terrains(this);
        }
    }
}