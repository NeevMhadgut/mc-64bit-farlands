import java.util.HashMap;
import java.util.List;
import java.util.Random;

public final class SpawnerAnimals {
   private static HashMap b = new HashMap();
   protected static final Class[] a = new Class[]{cb.class, EntityZombie.class, EntitySkeleton.class};

   protected static ChunkPosition getRandomSpawningPointInChunk(World par0World, long par1, long par2) {
      Chunk chunk = par0World.getChunkFromChunkCoords(par1, par2);
      long i = par1 * 16L + par0World.r.nextInt(16);
      int j = par0World.r.nextInt(chunk != null ? Math.max(128, chunk.h()) : 128);
      long k = par2 * 16L + par0World.r.nextInt(16);
      return new ChunkPosition(i, j, k);
   }

   private static boolean isCoordNotStupidlyFar(long xPos, long zPos) {
      return xPos < 17592186044416L && xPos >= -17592186044416L && zPos < 17592186044416L && zPos >= -17592186044416L;
   }

   public static final int a(World par0World, boolean par1, boolean par2) {
      if (!par1 && !par2) {
         return 0;
      }

      b.clear();

      for (int var3 = 0; var3 < par0World.d.size(); var3++) {
         EntityPlayer var4 = (EntityPlayer)par0World.d.get(var3);
         long var5 = MathHelper.d(var4.o / 16.0);
         long var6 = MathHelper.d(var4.q / 16.0);
         byte var7 = 8;

         for (int var8 = -var7; var8 <= var7; var8++) {
            for (int var9 = -var7; var9 <= var7; var9++) {
               boolean var10 = var8 == -var7 || var8 == var7 || var9 == -var7 || var9 == var7;
               ChunkCoordIntPair var11 = new ChunkCoordIntPair(var8 + var5, var9 + var6);
               if (!var10) {
                  b.put(var11, false);
               } else if (!b.containsKey(var11)) {
                  b.put(var11, true);
               }
            }
         }
      }

      int var45 = 0;
      ChunkCoordinates var31 = par0World.x();
      acf[] var32 = acf.values();
      long var6 = var32.length;

      for (int var33 = 0; var33 < var6; var33++) {
         acf var34 = var32[var33];
         if ((!var34.d() || par2) && (var34.d() || par1) && par0World.b(var34.a()) <= var34.b() * b.size() / 256) {
            label122:
            for (ChunkCoordIntPair var37 : b.keySet()) {
               if (!(Boolean)b.get(var37)) {
                  ChunkPosition var36 = getRandomSpawningPointInChunk(par0World, var37.a, var37.b);
                  long var12 = var36.a;
                  int var13 = var36.b;
                  long var14 = var36.c;
                  if (!par0World.isBlockNormalCube(var12, var13, var14)
                     && par0World.getBlockMaterial(var12, var13, var14) == var34.c()
                     && isCoordNotStupidlyFar(var12, var14)) {
                     int var15 = 0;

                     for (int var16 = 0; var16 < 3; var16++) {
                        long var17 = var12;
                        int var18 = var13;
                        long var19 = var14;
                        byte var20 = 6;
                        bg var21 = null;

                        for (int var22 = 0; var22 < 4; var22++) {
                           var17 += par0World.r.nextInt(var20) - par0World.r.nextInt(var20);
                           var18 += par0World.r.nextInt(1) - par0World.r.nextInt(1);
                           var19 += par0World.r.nextInt(var20) - par0World.r.nextInt(var20);
                           if (canCreatureTypeSpawnAtLocation(var34, par0World, var17, var18, var19)) {
                              double var23 = var17 + 0.5;
                              double var24 = var18;
                              double var25 = var19 + 0.5;
                              if (par0World.a(var23, var24, var25, 24.0) == null) {
                                 double var26 = var23 - var31.a;
                                 double var27 = var24 - var31.b;
                                 double var28 = var25 - var31.c;
                                 double var29 = var26 * var26 + var27 * var27 + var28 * var28;
                                 if (var29 >= 576.0) {
                                    if (var21 == null) {
                                       var21 = par0World.getRandomMob(var34, var17, var18, var19);
                                       if (var21 == null) {
                                          break;
                                       }
                                    }

                                    EntityLiving var38;
                                    try {
                                       var38 = (EntityLiving)var21.a.getConstructor(World.class).newInstance(par0World);
                                    } catch (Exception var30) {
                                       var30.printStackTrace();
                                       return var45;
                                    }

                                    var38.c(var23, var24, var25, par0World.r.nextFloat() * 360.0F, 0.0F);
                                    if (var38.i()) {
                                       var15++;
                                       par0World.a(var38);
                                       creatureSpecificInit(var38, par0World, var23, var24, var25);
                                       if (var15 >= var38.EntityNoteFX()) {
                                          continue label122;
                                       }
                                    }

                                    var45 += var15;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      return var45;
   }

   public static boolean canCreatureTypeSpawnAtLocation(acf par0EnumCreatureType, World par1World, long par2, int par3, long par4) {
      if (par0EnumCreatureType.c() == acn.g) {
         return par1World.getBlockMaterial(par2, par3, par4).d() && !par1World.isBlockNormalCube(par2, par3 + 1, par4);
      }

      int i = par1World.getBlockId(par2, par3 - 1, par4);
      return Block.g(i)
         && i != Block.z.bO
         && !par1World.isBlockNormalCube(par2, par3, par4)
         && !par1World.getBlockMaterial(par2, par3, par4).d()
         && !par1World.isBlockNormalCube(par2, par3 + 1, par4);
   }

   private static void creatureSpecificInit(EntityLiving par0EntityLiving, World par1World, double par2, double par3, double par4) {
      if (par0EntityLiving instanceof cb && par1World.r.nextInt(100) == 0) {
         EntitySkeleton entityskeleton = new EntitySkeleton(par1World);
         entityskeleton.c(par2, par3, par4, par0EntityLiving.u, 0.0F);
         par1World.a(entityskeleton);
         entityskeleton.h(par0EntityLiving);
      } else if (par0EntityLiving instanceof cu) {
         ((cu)par0EntityLiving).c_(cu.a(par1World.r));
      } else if (par0EntityLiving instanceof EntityOcelot && par1World.r.nextInt(7) == 0) {
         for (int i = 0; i < 2; i++) {
            EntityOcelot entityocelot = new EntityOcelot(par1World);
            entityocelot.c(par2, par3, par4, par0EntityLiving.u, 0.0F);
            entityocelot.d(-24000);
            par1World.a(entityocelot);
         }
      }
   }

   public static void performWorldGenSpawning(World par0World, BiomeGenBase par1BiomeGenBase, long par2, long par3, int par4, int par5, Random par6Random) {
      List list = par1BiomeGenBase.a(acf.b);
      if (!list.isEmpty()) {
         while (par6Random.nextFloat() < par1BiomeGenBase.f()) {
            bg spawnlistentry = (bg)pk.a(par0World.r, list);
            int i = spawnlistentry.b + par6Random.nextInt(1 + spawnlistentry.c - spawnlistentry.b);
            long j = par2 + par6Random.nextInt(par4);
            long k = par3 + par6Random.nextInt(par5);
            long l = j;
            long i1 = k;

            for (int j1 = 0; j1 < i; j1++) {
               boolean flag = false;

               for (int k1 = 0; !flag && k1 < 4; k1++) {
                  int l1 = par0World.getTopSolidOrLiquidBlock(j, k);
                  if (canCreatureTypeSpawnAtLocation(acf.b, par0World, j, l1, k) && isCoordNotStupidlyFar(j, k)) {
                     double f = j + 0.5;
                     double f1 = l1;
                     double f2 = k + 0.5;

                     EntityLiving entityliving;
                     try {
                        entityliving = (EntityLiving)spawnlistentry.a.getConstructor(World.class).newInstance(par0World);
                     } catch (Exception exception) {
                        exception.printStackTrace();
                        continue;
                     }

                     entityliving.c(f, f1, f2, par6Random.nextFloat() * 360.0F, 0.0F);
                     par0World.a(entityliving);
                     creatureSpecificInit(entityliving, par0World, f, f1, f2);
                     flag = true;
                  }

                  j += par6Random.nextInt(5) - par6Random.nextInt(5);

                  for (k += par6Random.nextInt(5) - par6Random.nextInt(5);
                     j < par2 || j >= par2 + par4 || k < par3 || k >= par3 + par4;
                     k = i1 + par6Random.nextInt(5) - par6Random.nextInt(5)
                  ) {
                     j = l + par6Random.nextInt(5) - par6Random.nextInt(5);
                  }
               }
            }
         }
      }
   }
}
