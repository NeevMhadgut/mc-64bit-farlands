import java.util.Random;

public class WorldGenDungeons extends WorldGenerator {
   @Override
   public boolean generate(World par1World, Random par2Random, long par3, int par4, long par5) {
      byte byte0 = 3;
      int i = par2Random.nextInt(2) + 2;
      int j = par2Random.nextInt(2) + 2;
      int k = 0;

      for (long l = par3 - i - 1L; l <= par3 + i + 1L; l++) {
         for (int k1 = par4 - 1; k1 <= par4 + byte0 + 1; k1++) {
            for (long j2 = par5 - j - 1L; j2 <= par5 + j + 1L; j2++) {
               acn material = par1World.getBlockMaterial(l, k1, j2);
               if (k1 == par4 - 1 && !material.a()) {
                  return false;
               }

               if (k1 == par4 + byte0 + 1 && !material.a()) {
                  return false;
               }

               if ((l == par3 - i - 1L || l == par3 + i + 1L || j2 == par5 - j - 1L || j2 == par5 + j + 1L)
                  && k1 == par4
                  && par1World.isAirBlock(l, k1, j2)
                  && par1World.isAirBlock(l, k1 + 1, j2)) {
                  k++;
               }
            }
         }
      }

      if (k >= 1 && k <= 5) {
         for (long i1 = par3 - i - 1L; i1 <= par3 + i + 1L; i1++) {
            for (int l1 = par4 + byte0; l1 >= par4 - 1; l1--) {
               for (long k2 = par5 - j - 1L; k2 <= par5 + j + 1L; k2++) {
                  if (i1 != par3 - i - 1L && l1 != par4 - 1 && k2 != par5 - j - 1L && i1 != par3 + i + 1L && l1 != par4 + byte0 + 1 && k2 != par5 + j + 1L) {
                     par1World.setBlockWithNotify(i1, l1, k2, 0);
                  } else if (l1 >= 0 && !par1World.getBlockMaterial(i1, l1 - 1, k2).a()) {
                     par1World.setBlockWithNotify(i1, l1, k2, 0);
                  } else if (par1World.getBlockMaterial(i1, l1, k2).a()) {
                     if (l1 == par4 - 1 && par2Random.nextInt(4) != 0) {
                        par1World.setBlockWithNotify(i1, l1, k2, Block.GenLayerHills.bO);
                     } else {
                        par1World.setBlockWithNotify(i1, l1, k2, Block.w.bO);
                     }
                  }
               }
            }
         }

         for (int j1 = 0; j1 < 2; j1++) {
            for (int i2 = 0; i2 < 3; i2++) {
               long l2 = par3 + par2Random.nextInt(i * 2 + 1) - i;
               int i3 = par4;
               long j3 = par5 + par2Random.nextInt(j * 2 + 1) - j;
               if (par1World.isAirBlock(l2, i3, j3)) {
                  int k3 = 0;
                  if (par1World.getBlockMaterial(l2 - 1L, i3, j3).a()) {
                     k3++;
                  }

                  if (par1World.getBlockMaterial(l2 + 1L, i3, j3).a()) {
                     k3++;
                  }

                  if (par1World.getBlockMaterial(l2, i3, j3 - 1L).a()) {
                     k3++;
                  }

                  if (par1World.getBlockMaterial(l2, i3, j3 + 1L).a()) {
                     k3++;
                  }

                  if (k3 == 1) {
                     par1World.setBlockWithNotify(l2, i3, j3, Block.au.bO);
                     TileEntityChest tileentitychest = (TileEntityChest)par1World.getBlockTileEntity(l2, i3, j3);
                     if (tileentitychest != null) {
                        for (int l3 = 0; l3 < 8; l3++) {
                           ItemStack itemstack = this.a(par2Random);
                           if (itemstack != null) {
                              tileentitychest.a(par2Random.nextInt(tileentitychest.a()), itemstack);
                           }
                        }
                     }
                     break;
                  }
               }
            }
         }

         par1World.setBlockWithNotify(par3, par4, par5, Block.as.bO);
         TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)par1World.getBlockTileEntity(par3, par4, par5);
         if (tileentitymobspawner != null) {
            tileentitymobspawner.a(this.b(par2Random));
         } else {
            System.err.println("Failed WorldGenTallGrass fetch mob spawner entity at (" + par3 + ", " + par4 + ", " + par5 + ")");
         }

         return true;
      } else {
         return false;
      }
   }

   private ItemStack a(Random par1Random) {
      int i = par1Random.nextInt(11);
      if (i == 0) {
         return new ItemStack(Item.aA);
      } else if (i == 1) {
         return new ItemStack(Item.o, par1Random.nextInt(4) + 1);
      } else if (i == 2) {
         return new ItemStack(Item.U);
      } else if (i == 3) {
         return new ItemStack(Item.T, par1Random.nextInt(4) + 1);
      } else if (i == 4) {
         return new ItemStack(Item.M, par1Random.nextInt(4) + 1);
      } else if (i == 5) {
         return new ItemStack(Item.K, par1Random.nextInt(4) + 1);
      } else if (i == 6) {
         return new ItemStack(Item.aw);
      } else if (i == 7 && par1Random.nextInt(100) == 0) {
         return new ItemStack(Item.at);
      } else if (i == 8 && par1Random.nextInt(2) == 0) {
         return new ItemStack(Item.aC, par1Random.nextInt(4) + 1);
      } else if (i == 9 && par1Random.nextInt(10) == 0) {
         return new ItemStack(Item.e[Item.bF.bQ + par1Random.nextInt(2)]);
      } else {
         return i == 10 ? new ItemStack(Item.aW, 1, 3) : null;
      }
   }

   private String b(Random par1Random) {
      int i = par1Random.nextInt(4);
      if (i == 0) {
         return "Skeleton";
      } else if (i == 1) {
         return "Zombie";
      } else if (i == 2) {
         return "Zombie";
      } else {
         return i == 3 ? "Spider" : "";
      }
   }
}
