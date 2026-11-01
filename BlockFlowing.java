import java.util.Random;

public class BlockFlowing extends BlockFluid {
   int a = 0;
   boolean[] b = new boolean[4];
   int[] c = new int[4];

   protected BlockFlowing(int par1, acn par2Material) {
      super(par1, par2Material);
   }

   private void updateFlow(World par1World, long par2, int par3, long par4) {
      int i = par1World.getBlockMetadata(par2, par3, par4);
      par1World.setBlockAndMetadata(par2, par3, par4, this.bO + 1, i);
      par1World.markBlocksDirty(par2, par3, par4, par2, par3, par4);
      par1World.markBlockNeedsUpdate(par2, par3, par4);
   }

   @Override
   public boolean getBlocksMovement(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      return this.cd != acn.h;
   }

   @Override
   public void updateTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      int i = this.getFlowDecay(par1World, par2, par3, par4);
      byte byte0 = 1;
      if (this.cd == acn.h && !par1World.t.d) {
         byte0 = 2;
      }

      boolean flag = true;
      if (i > 0) {
         int j = -100;
         this.a = 0;
         j = this.getSmallestFlowDecay(par1World, par2 - 1L, par3, par4, j);
         j = this.getSmallestFlowDecay(par1World, par2 + 1L, par3, par4, j);
         j = this.getSmallestFlowDecay(par1World, par2, par3, par4 - 1L, j);
         j = this.getSmallestFlowDecay(par1World, par2, par3, par4 + 1L, j);
         int k = j + byte0;
         if (k >= 8 || j < 0) {
            k = -1;
         }

         if (this.getFlowDecay(par1World, par2, par3 + 1, par4) >= 0) {
            int i1 = this.getFlowDecay(par1World, par2, par3 + 1, par4);
            if (i1 >= 8) {
               k = i1;
            } else {
               k = i1 + 8;
            }
         }

         if (this.a >= 2 && this.cd == acn.g) {
            if (par1World.getBlockMaterial(par2, par3 - 1, par4).a()) {
               k = 0;
            } else if (par1World.getBlockMaterial(par2, par3 - 1, par4) == this.cd && par1World.getBlockMetadata(par2, par3 - 1, par4) == 0) {
               k = 0;
            }
         }

         if (this.cd == acn.h && i < 8 && k < 8 && k > i && par5Random.nextInt(4) != 0) {
            k = i;
            flag = false;
         }

         if (k != i) {
            i = k;
            if (i < 0) {
               par1World.setBlockWithNotify(par2, par3, par4, 0);
            } else {
               par1World.setBlockMetadataWithNotify(par2, par3, par4, i);
               par1World.scheduleBlockUpdate(par2, par3, par4, this.bO, this.e());
               par1World.notifyBlocksOfNeighborChange(par2, par3, par4, this.bO);
            }
         } else if (flag) {
            this.updateFlow(par1World, par2, par3, par4);
         }
      } else {
         this.updateFlow(par1World, par2, par3, par4);
      }

      if (this.liquidCanDisplaceBlock(par1World, par2, par3 - 1, par4)) {
         if (this.cd == acn.h && par1World.getBlockMaterial(par2, par3 - 1, par4) == acn.g) {
            par1World.setBlockWithNotify(par2, par3 - 1, par4, Block.t.bO);
            this.triggerLavaMixEffects(par1World, par2, par3 - 1, par4);
            return;
         }

         if (i >= 8) {
            par1World.setBlockAndMetadataWithNotify(par2, par3 - 1, par4, this.bO, i);
         } else {
            par1World.setBlockAndMetadataWithNotify(par2, par3 - 1, par4, this.bO, i + 8);
         }
      } else if (i >= 0 && (i == 0 || this.blockBlocksFlow(par1World, par2, par3 - 1, par4))) {
         boolean[] aflag = this.getOptimalFlowDirections(par1World, par2, par3, par4);
         int l = i + byte0;
         if (i >= 8) {
            l = 1;
         }

         if (l >= 8) {
            return;
         }

         if (aflag[0]) {
            this.flowIntoBlock(par1World, par2 - 1L, par3, par4, l);
         }

         if (aflag[1]) {
            this.flowIntoBlock(par1World, par2 + 1L, par3, par4, l);
         }

         if (aflag[2]) {
            this.flowIntoBlock(par1World, par2, par3, par4 - 1L, l);
         }

         if (aflag[3]) {
            this.flowIntoBlock(par1World, par2, par3, par4 + 1L, l);
         }
      }
   }

   private void flowIntoBlock(World par1World, long par2, int par3, long par4, int par5) {
      if (this.liquidCanDisplaceBlock(par1World, par2, par3, par4)) {
         int i = par1World.getBlockId(par2, par3, par4);
         if (i > 0) {
            if (this.cd == acn.h) {
               this.triggerLavaMixEffects(par1World, par2, par3, par4);
            } else {
               Block.m[i].dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
            }
         }

         par1World.setBlockAndMetadataWithNotify(par2, par3, par4, this.bO, par5);
      }
   }

   private int calculateFlowCost(World par1World, long par2, int par3, long par4, int par5, int par6) {
      int i = 1000;

      for (int j = 0; j < 4; j++) {
         if ((j != 0 || par6 != 1) && (j != 1 || par6 != 0) && (j != 2 || par6 != 3) && (j != 3 || par6 != 2)) {
            long k = par2;
            int l = par3;
            long i1 = par4;
            if (j == 0) {
               k--;
            }

            if (j == 1) {
               k++;
            }

            if (j == 2) {
               i1--;
            }

            if (j == 3) {
               i1++;
            }

            if (!this.blockBlocksFlow(par1World, k, l, i1) && (par1World.getBlockMaterial(k, l, i1) != this.cd || par1World.getBlockMetadata(k, l, i1) != 0)) {
               if (!this.blockBlocksFlow(par1World, k, l - 1, i1)) {
                  return par5;
               }

               if (par5 < 4) {
                  int j1 = this.calculateFlowCost(par1World, k, l, i1, par5 + 1, j);
                  if (j1 < i) {
                     i = j1;
                  }
               }
            }
         }
      }

      return i;
   }

   private boolean[] getOptimalFlowDirections(World par1World, long par2, int par3, long par4) {
      for (int i = 0; i < 4; i++) {
         this.c[i] = 1000;
         long k = par2;
         int j1 = par3;
         long k1 = par4;
         if (i == 0) {
            k--;
         }

         if (i == 1) {
            k++;
         }

         if (i == 2) {
            k1--;
         }

         if (i == 3) {
            k1++;
         }

         if (!this.blockBlocksFlow(par1World, k, j1, k1) && (par1World.getBlockMaterial(k, j1, k1) != this.cd || par1World.getBlockMetadata(k, j1, k1) != 0)) {
            if (!this.blockBlocksFlow(par1World, k, j1 - 1, k1)) {
               this.c[i] = 0;
            } else {
               this.c[i] = this.calculateFlowCost(par1World, k, j1, k1, 1, i);
            }
         }
      }

      int j = this.c[0];

      for (int l = 1; l < 4; l++) {
         if (this.c[l] < j) {
            j = this.c[l];
         }
      }

      for (int i1 = 0; i1 < 4; i1++) {
         this.b[i1] = this.c[i1] == j;
      }

      return this.b;
   }

   private boolean blockBlocksFlow(World par1World, long par2, int par3, long par4) {
      int i = par1World.getBlockId(par2, par3, par4);
      if (i == Block.aE.bO || i == Block.aL.bO || i == Block.aD.bO || i == Block.aF.bO || i == Block.aX.bO) {
         return true;
      }

      if (i == 0) {
         return false;
      }

      acn material = Block.m[i].cd;
      return material == acn.B ? true : material.c();
   }

   protected int getSmallestFlowDecay(World par1World, long par2, int par3, long par4, int par5) {
      int i = this.getFlowDecay(par1World, par2, par3, par4);
      if (i < 0) {
         return par5;
      }

      if (i == 0) {
         this.a++;
      }

      if (i >= 8) {
         i = 0;
      }

      return par5 >= 0 && i >= par5 ? par5 : i;
   }

   private boolean liquidCanDisplaceBlock(World par1World, long par2, int par3, long par4) {
      acn material = par1World.getBlockMaterial(par2, par3, par4);
      if (material == this.cd) {
         return false;
      } else {
         return material == acn.h ? false : !this.blockBlocksFlow(par1World, par2, par3, par4);
      }
   }

   @Override
   public void onBlockAdded(World par1World, long par2, int par3, long par4) {
      super.onBlockAdded(par1World, par2, par3, par4);
      if (par1World.getBlockId(par2, par3, par4) == this.bO) {
         par1World.scheduleBlockUpdate(par2, par3, par4, this.bO, this.e());
      }
   }
}
