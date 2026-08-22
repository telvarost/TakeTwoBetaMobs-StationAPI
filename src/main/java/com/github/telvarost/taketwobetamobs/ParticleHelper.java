package com.github.telvarost.taketwobetamobs;

import net.minecraft.world.World;

public class ParticleHelper {

    public static void spawnStructureCompleteParticles(boolean isNewToChunk, World world, int x, int y, int z) {
        if (isNewToChunk) {
            world.addParticle("reddust", (double) x + 0.0f, (double) y + 0.0f, (double) z + 0.0f, 0.0078125f, 1.0f, 1.0f);
            world.addParticle("reddust", (double) x + 0.0f, (double) y + 0.0f, (double) z + 1.0f, 0.0078125f, 1.0f, 1.0f);
            world.addParticle("reddust", (double) x + 0.0f, (double) y + 1.0f, (double) z + 0.0f, 0.0078125f, 1.0f, 1.0f);
            world.addParticle("reddust", (double) x + 0.0f, (double) y + 1.0f, (double) z + 1.0f, 0.0078125f, 1.0f, 1.0f);
            world.addParticle("reddust", (double) x + 1.0f, (double) y + 0.0f, (double) z + 0.0f, 0.0078125f, 1.0f, 1.0f);
            world.addParticle("reddust", (double) x + 1.0f, (double) y + 0.0f, (double) z + 1.0f, 0.0078125f, 1.0f, 1.0f);
            world.addParticle("reddust", (double) x + 1.0f, (double) y + 1.0f, (double) z + 0.0f, 0.0078125f, 1.0f, 1.0f);
            world.addParticle("reddust", (double) x + 1.0f, (double) y + 1.0f, (double) z + 1.0f, 0.0078125f, 1.0f, 1.0f);
            world.addParticle("reddust", (double) x + 0.5f, (double) y + 0.5f, (double) z + 0.5f, 0.0078125f, 1.0f, 1.0f);
            world.addParticle("reddust", (double) x + 0.5f, (double) y + 1.5f, (double) z + 0.5f, 0.0078125f, 1.0f, 1.0f);
            for (int darken = 0; darken < 2; darken++) {
                world.addParticle("footstep", (double) x + 0.25f, (double) y + 1.125f, (double) z + 0.5f, 0, 0, 0);
                world.addParticle("footstep", (double) x + 0.75f, (double) y + 1.125f, (double) z + 0.5f, 0, 0, 0);
                world.addParticle("footstep", (double) x + 0.5f, (double) y + 1.125f, (double) z + 0.25f, 0, 0, 0);
                world.addParticle("footstep", (double) x + 0.5f, (double) y + 1.125f, (double) z + 0.75f, 0, 0, 0);
                world.addParticle("footstep", (double) x + 0.0f, (double) y + 0.5f, (double) z + 0.5f, 0, 0, 0);
                world.addParticle("footstep", (double) x + 1.0f, (double) y + 0.5f, (double) z + 0.5f, 0, 0, 0);
                world.addParticle("footstep", (double) x + 0.5f, (double) y + 0.5f, (double) z + 0.0f, 0, 0, 0);
                world.addParticle("footstep", (double) x + 0.5f, (double) y + 0.5f, (double) z + 1.0f, 0, 0, 0);
            }
        } else {
            world.addParticle("reddust", (double)x + 0.0f, (double)y + 0.0f, (double)z + 0.0f, 0.0078125f, 0.875f, 0.375f);
            world.addParticle("reddust", (double)x + 0.0f, (double)y + 0.0f, (double)z + 1.0f, 0.0078125f, 0.875f, 0.375f);
            world.addParticle("reddust", (double)x + 0.0f, (double)y + 1.0f, (double)z + 0.0f, 0.0078125f, 0.875f, 0.375f);
            world.addParticle("reddust", (double)x + 0.0f, (double)y + 1.0f, (double)z + 1.0f, 0.0078125f, 0.875f, 0.375f);
            world.addParticle("reddust", (double)x + 1.0f, (double)y + 0.0f, (double)z + 0.0f, 0.0078125f, 0.875f, 0.375f);
            world.addParticle("reddust", (double)x + 1.0f, (double)y + 0.0f, (double)z + 1.0f, 0.0078125f, 0.875f, 0.375f);
            world.addParticle("reddust", (double)x + 1.0f, (double)y + 1.0f, (double)z + 0.0f, 0.0078125f, 0.875f, 0.375f);
            world.addParticle("reddust", (double)x + 1.0f, (double)y + 1.0f, (double)z + 1.0f, 0.0078125f, 0.875f, 0.375f);
            world.addParticle("reddust", (double)x + 0.5f, (double)y + 0.5f, (double)z + 0.5f, 0.0078125f, 0.875f, 0.375f);
            world.addParticle("reddust", (double)x + 0.5f, (double)y + 1.5f, (double)z + 0.5f, 0.0078125f, 0.875f, 0.375f);
            for (int darken = 0; darken < 2; darken++) {
                world.addParticle("footstep", (double) x + 0.5f, (double) y + 1.125f, (double) z + 0.5f, 0, 0, 0);
            }
        }
    }
}
