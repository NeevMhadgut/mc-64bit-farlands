import java.util.List;
import java.util.Random;

public abstract class StructureComponent {
   protected StructureBoundingBox g;
   protected int h;
   protected int i;

   protected StructureComponent(int par1) {
      this.i = par1;
      this.h = -1;
   }

   public void a(StructureComponent structurecomponent, List list, Random random) {
   }

   public abstract boolean a(World var1, Random var2, StructureBoundingBox var3);

   public StructureBoundingBox b() {
      return this.g;
   }

   public int c() {
      return this.i;
   }

   public static StructureComponent a(List par0List, StructureBoundingBox par1StructureBoundingBox) {
      for (StructureComponent structurecomponent : par0List) {
         if (structurecomponent.b() != null && structurecomponent.b().a(par1StructureBoundingBox)) {
            return structurecomponent;
         }
      }

      return null;
   }

   public ChunkPosition a_() {
      return new ChunkPosition(this.g.getCenterX(), this.g.f(), this.g.getCenterZ());
   }

   protected boolean a(World par1World, StructureBoundingBox par2StructureBoundingBox) {
      long i = Math.max(this.g.a - 1L, par2StructureBoundingBox.a);
      int j = Math.max(this.g.b - 1, par2StructureBoundingBox.b);
      long k = Math.max(this.g.c - 1L, par2StructureBoundingBox.c);
      long l = Math.min(this.g.d + 1L, par2StructureBoundingBox.d);
      int i1 = Math.min(this.g.e + 1, par2StructureBoundingBox.e);
      long j1 = Math.min(this.g.f + 1L, par2StructureBoundingBox.f);

      for (long k1 = i; k1 <= l; k1++) {
         for (long j2 = k; j2 <= j1; j2++) {
            int i3 = par1World.getBlockId(k1, j, j2);
            if (i3 > 0 && Block.m[i3].cd.d()) {
               return true;
            }

            i3 = par1World.getBlockId(k1, i1, j2);
            if (i3 > 0 && Block.m[i3].cd.d()) {
               return true;
            }
         }
      }

      for (long l1 = i; l1 <= l; l1++) {
         for (int k2 = j; k2 <= i1; k2++) {
            int j3 = par1World.getBlockId(l1, k2, k);
            if (j3 > 0 && Block.m[j3].cd.d()) {
               return true;
            }

            j3 = par1World.getBlockId(l1, k2, j1);
            if (j3 > 0 && Block.m[j3].cd.d()) {
               return true;
            }
         }
      }

      for (long i2 = k; i2 <= j1; i2++) {
         for (int l2 = j; l2 <= i1; l2++) {
            int k3 = par1World.getBlockId(i, l2, i2);
            if (k3 > 0 && Block.m[k3].cd.d()) {
               return true;
            }

            k3 = par1World.getBlockId(l, l2, i2);
            if (k3 > 0 && Block.m[k3].cd.d()) {
               return true;
            }
         }
      }

      return false;
   }

   protected long getXWithOffset(long par1, long par2) {
      switch (this.h) {
         case 0:
         case 2:
            return this.g.a + par1;
         case 1:
            return this.g.d - par2;
         case 3:
            return this.g.a + par2;
         default:
            return par1;
      }
   }

   protected int b(int par1) {
      return this.h == -1 ? par1 : par1 + this.g.b;
   }

   protected long getZWithOffset(long par1, long par2) {
      switch (this.h) {
         case 0:
            return this.g.c + par2;
         case 1:
         case 3:
            return this.g.c + par1;
         case 2:
            return this.g.f - par2;
         default:
            return par2;
      }
   }

   protected int c(int par1, int par2) {
      if (par1 == Block.aG.bO) {
         if (this.h == 1 || this.h == 3) {
            return par2 != 1 ? 1 : 0;
         }
      } else if (par1 != Block.aE.bO && par1 != Block.aL.bO) {
         if (par1 != Block.aH.bO && par1 != Block.at.bO && par1 != Block.bC.bO && par1 != Block.bx.bO) {
            if (par1 == Block.aF.bO) {
               if (this.h == 0) {
                  if (par2 == 2) {
                     return 3;
                  }

                  if (par2 == 3) {
                     return 2;
                  }
               } else if (this.h == 1) {
                  if (par2 == 2) {
                     return 4;
                  }

                  if (par2 == 3) {
                     return 5;
                  }

                  if (par2 == 4) {
                     return 2;
                  }

                  if (par2 == 5) {
                     return 3;
                  }
               } else if (this.h == 3) {
                  if (par2 == 2) {
                     return 5;
                  }

                  if (par2 == 3) {
                     return 4;
                  }

                  if (par2 == 4) {
                     return 2;
                  }

                  if (par2 == 5) {
                     return 3;
                  }
               }
            } else if (par1 == Block.aR.bO) {
               if (this.h == 0) {
                  if (par2 == 3) {
                     return 4;
                  }

                  if (par2 == 4) {
                     return 3;
                  }
               } else if (this.h == 1) {
                  if (par2 == 3) {
                     return 1;
                  }

                  if (par2 == 4) {
                     return 2;
                  }

                  if (par2 == 2) {
                     return 3;
                  }

                  if (par2 == 1) {
                     return 4;
                  }
               } else if (this.h == 3) {
                  if (par2 == 3) {
                     return 2;
                  }

                  if (par2 == 4) {
                     return 1;
                  }

                  if (par2 == 2) {
                     return 3;
                  }

                  if (par2 == 1) {
                     return 4;
                  }
               }
            }
         } else if (this.h == 0) {
            if (par2 == 2) {
               return 3;
            }

            if (par2 == 3) {
               return 2;
            }
         } else if (this.h == 1) {
            if (par2 == 0) {
               return 2;
            }

            if (par2 == 1) {
               return 3;
            }

            if (par2 == 2) {
               return 0;
            }

            if (par2 == 3) {
               return 1;
            }
         } else if (this.h == 3) {
            if (par2 == 0) {
               return 2;
            }

            if (par2 == 1) {
               return 3;
            }

            if (par2 == 2) {
               return 1;
            }

            if (par2 == 3) {
               return 0;
            }
         }
      } else if (this.h == 0) {
         if (par2 == 0) {
            return 2;
         }

         if (par2 == 2) {
            return 0;
         }
      } else {
         if (this.h == 1) {
            return par2 + 1 & 3;
         }

         if (this.h == 3) {
            return par2 + 3 & 3;
         }
      }

      return par2;
   }

   protected void placeBlockAtCurrentPosition(World par1World, int par2, int par3, long par4, int par5, long par6, StructureBoundingBox par7StructureBoundingBox) {
      long i = this.getXWithOffset(par4, par6);
      int j = this.b(par5);
      long k = this.getZWithOffset(par4, par6);
      if (par7StructureBoundingBox.isVecInside(i, j, k)) {
         par1World.setBlockAndMetadata(i, j, k, par2, par3);
      }
   }

   protected int getBlockIdAtCurrentPosition(World par1World, long par2, int par3, long par4, StructureBoundingBox par5StructureBoundingBox) {
      long i = this.getXWithOffset(par2, par4);
      int j = this.b(par3);
      long k = this.getZWithOffset(par2, par4);
      return !par5StructureBoundingBox.isVecInside(i, j, k) ? 0 : par1World.getBlockId(i, j, k);
   }

   protected void fillWithBlocks(
      World par1World, StructureBoundingBox par2StructureBoundingBox, long par3, int par4, long par5, long par6, int par7, long par8, int par9, int par10, boolean par11
   ) {
      for (int i = par4; i <= par7; i++) {
         for (long j = par3; j <= par6; j++) {
            for (long k = par5; k <= par8; k++) {
               if (!par11 || this.getBlockIdAtCurrentPosition(par1World, j, i, k, par2StructureBoundingBox) != 0) {
                  if (i != par4 && i != par7 && j != par3 && j != par6 && k != par5 && k != par8) {
                     this.placeBlockAtCurrentPosition(par1World, par10, 0, j, i, k, par2StructureBoundingBox);
                  } else {
                     this.placeBlockAtCurrentPosition(par1World, par9, 0, j, i, k, par2StructureBoundingBox);
                  }
               }
            }
         }
      }
   }

   protected void fillWithRandomizedBlocks(
      World par1World,
      StructureBoundingBox par2StructureBoundingBox,
      long par3,
      int par4,
      long par5,
      long par6,
      int par7,
      long par8,
      boolean par9,
      Random par10Random,
      StructurePieceBlockSelector par11StructurePieceBlockSelector
   ) {
      for (int i = par4; i <= par7; i++) {
         for (long j = par3; j <= par6; j++) {
            for (long k = par5; k <= par8; k++) {
               if (!par9 || this.getBlockIdAtCurrentPosition(par1World, j, i, k, par2StructureBoundingBox) != 0) {
                  par11StructurePieceBlockSelector.selectBlocks(
                     par10Random, j, i, k, i == par4 || i == par7 || j == par3 || j == par6 || k == par5 || k == par8
                  );
                  this.placeBlockAtCurrentPosition(
                     par1World, par11StructurePieceBlockSelector.a(), par11StructurePieceBlockSelector.b(), j, i, k, par2StructureBoundingBox
                  );
               }
            }
         }
      }
   }

   protected void randomlyFillWithBlocks(
      World par1World,
      StructureBoundingBox par2StructureBoundingBox,
      Random par3Random,
      float par4,
      long par5,
      int par6,
      long par7,
      long par8,
      int par9,
      long par10,
      int par11,
      int par12,
      boolean par13
   ) {
      for (int i = par6; i <= par9; i++) {
         for (long j = par5; j <= par8; j++) {
            for (long k = par7; k <= par10; k++) {
               if (!(par3Random.nextFloat() > par4) && (!par13 || this.getBlockIdAtCurrentPosition(par1World, j, i, k, par2StructureBoundingBox) != 0)) {
                  if (i != par6 && i != par9 && j != par5 && j != par8 && k != par7 && k != par10) {
                     this.placeBlockAtCurrentPosition(par1World, par12, 0, j, i, k, par2StructureBoundingBox);
                  } else {
                     this.placeBlockAtCurrentPosition(par1World, par11, 0, j, i, k, par2StructureBoundingBox);
                  }
               }
            }
         }
      }
   }

   protected void randomlyPlaceBlock(
      World par1World, StructureBoundingBox par2StructureBoundingBox, Random par3Random, float par4, long par5, int par6, long par7, int par8, int par9
   ) {
      if (par3Random.nextFloat() < par4) {
         this.placeBlockAtCurrentPosition(par1World, par8, par9, par5, par6, par7, par2StructureBoundingBox);
      }
   }

   protected void randomlyRareFillWithBlocks(
      World par1World, StructureBoundingBox par2StructureBoundingBox, long par3, int par4, long par5, long par6, int par7, long par8, int par9, boolean par10
   ) {
      double f = par6 - par3 + 1L;
      double f1 = par7 - par4 + 1;
      double f2 = par8 - par5 + 1L;
      double f3 = par3 + f / 2.0;
      double f4 = par5 + f2 / 2.0;

      for (int i = par4; i <= par7; i++) {
         double f5 = (i - par4) / f1;

         for (long j = par3; j <= par6; j++) {
            double f6 = (j - f3) / (f * 0.5);

            for (long k = par5; k <= par8; k++) {
               double f7 = (k - f4) / (f2 * 0.5);
               if (!par10 || this.getBlockIdAtCurrentPosition(par1World, j, i, k, par2StructureBoundingBox) != 0) {
                  double f8 = f6 * f6 + f5 * f5 + f7 * f7;
                  if (f8 <= 1.05) {
                     this.placeBlockAtCurrentPosition(par1World, par9, 0, j, i, k, par2StructureBoundingBox);
                  }
               }
            }
         }
      }
   }

   protected void clearCurrentPositionBlocksUpwards(World par1World, long par2, int par3, long par4, StructureBoundingBox par5StructureBoundingBox) {
      long i = this.getXWithOffset(par2, par4);
      int j = this.b(par3);
      long k = this.getZWithOffset(par2, par4);
      if (par5StructureBoundingBox.isVecInside(i, j, k)) {
         while (!par1World.isAirBlock(i, j, k) && j < 255) {
            par1World.setBlockAndMetadata(i, j, k, 0, 0);
            j++;
         }
      }
   }

   protected void fillCurrentPositionBlocksDownwards(World par1World, int par2, int par3, long par4, int par5, long par6, StructureBoundingBox par7StructureBoundingBox) {
      long i = this.getXWithOffset(par4, par6);
      int j = this.b(par5);
      long k = this.getZWithOffset(par4, par6);
      if (par7StructureBoundingBox.isVecInside(i, j, k)) {
         while ((par1World.isAirBlock(i, j, k) || par1World.getBlockMaterial(i, j, k).d()) && j > 1) {
            par1World.setBlockAndMetadata(i, j, k, par2, par3);
            j--;
         }
      }
   }

   protected void createTreasureChestAtCurrentPosition(
      World par1World, StructureBoundingBox par2StructureBoundingBox, Random par3Random, long par4, int par5, long par6, fx[] par7ArrayOfStructurePieceTreasure, int par8
   ) {
      long i = this.getXWithOffset(par4, par6);
      int j = this.b(par5);
      long k = this.getZWithOffset(par4, par6);
      if (par2StructureBoundingBox.isVecInside(i, j, k) && par1World.getBlockId(i, j, k) != Block.au.bO) {
         par1World.setBlockWithNotify(i, j, k, Block.au.bO);
         TileEntityChest tileentitychest = (TileEntityChest)par1World.getBlockTileEntity(i, j, k);
         if (tileentitychest != null) {
            a(par3Random, par7ArrayOfStructurePieceTreasure, tileentitychest, par8);
         }
      }
   }

   private static void a(Random par0Random, fx[] par1ArrayOfStructurePieceTreasure, TileEntityChest par2TileEntityChest, int par3) {
      for (int i = 0; i < par3; i++) {
         fx structurepiecetreasure = (fx)pk.a(par0Random, par1ArrayOfStructurePieceTreasure);
         int j = structurepiecetreasure.c + par0Random.nextInt(structurepiecetreasure.e - structurepiecetreasure.c + 1);
         if (Item.e[structurepiecetreasure.a].f() >= j) {
            par2TileEntityChest.a(par0Random.nextInt(par2TileEntityChest.a()), new ItemStack(structurepiecetreasure.a, j, structurepiecetreasure.b));
         } else {
            for (int k = 0; k < j; k++) {
               par2TileEntityChest.a(par0Random.nextInt(par2TileEntityChest.a()), new ItemStack(structurepiecetreasure.a, 1, structurepiecetreasure.b));
            }
         }
      }
   }

   protected void placeDoorAtCurrentPosition(World par1World, StructureBoundingBox par2StructureBoundingBox, Random par3Random, long par4, int par5, long par6, int par7) {
      long i = this.getXWithOffset(par4, par6);
      int j = this.b(par5);
      long k = this.getZWithOffset(par4, par6);
      if (par2StructureBoundingBox.isVecInside(i, j, k)) {
         ItemDoor.placeDoorBlock(par1World, i, j, k, par7, Block.aE);
      }
   }
}
