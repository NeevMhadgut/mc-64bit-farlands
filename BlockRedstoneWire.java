import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BlockRedstoneWire extends Block {
   private boolean a = true;
   private Set b = new HashSet();

   public BlockRedstoneWire(int par1, int par2) {
      super(par1, par2, acn.p);
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
   }

   @Override
   public int a(int par1, int par2) {
      return this.bN;
   }

   @Override
   public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, long par2, int par3, long i) {
      return null;
   }

   @Override
   public boolean a() {
      return false;
   }

   @Override
   public boolean b() {
      return false;
   }

   @Override
   public int d() {
      return 5;
   }

   @Override
   public int colorMultiplier(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      return 8388608;
   }

   @Override
   public boolean canPlaceBlockAt(World par1World, long par2, int par3, long par4) {
      return par1World.isBlockNormalCube(par2, par3 - 1, par4) || par1World.getBlockId(par2, par3 - 1, par4) == Block.bd.bO;
   }

   private void updateAndPropagateCurrentStrength(World par1World, long par2, int par3, long par4) {
      this.calculateCurrentChanges(par1World, par2, par3, par4, par2, par3, par4);
      ArrayList arraylist = new ArrayList(this.b);
      this.b.clear();

      for (int i = 0; i < arraylist.size(); i++) {
         ChunkPosition chunkposition = (ChunkPosition)arraylist.get(i);
         par1World.notifyBlocksOfNeighborChange(chunkposition.a, chunkposition.b, chunkposition.c, this.bO);
      }
   }

   private void calculateCurrentChanges(World par1World, long par2, int par3, long par4, long par5, int par6, long par7) {
      int i = par1World.getBlockMetadata(par2, par3, par4);
      int j = 0;
      this.a = false;
      boolean flag = par1World.isBlockIndirectlyGettingPowered(par2, par3, par4);
      this.a = true;
      if (flag) {
         j = 15;
      } else {
         for (int k = 0; k < 4; k++) {
            long i1 = par2;
            long k1 = par4;
            if (k == 0) {
               i1--;
            }

            if (k == 1) {
               i1++;
            }

            if (k == 2) {
               k1--;
            }

            if (k == 3) {
               k1++;
            }

            if (i1 != par5 || par3 != par6 || k1 != par7) {
               j = this.getMaxCurrentStrength(par1World, i1, par3, k1, j);
            }

            if (par1World.isBlockNormalCube(i1, par3, k1) && !par1World.isBlockNormalCube(par2, par3 + 1, par4)) {
               if (i1 != par5 || par3 + 1 != par6 || k1 != par7) {
                  j = this.getMaxCurrentStrength(par1World, i1, par3 + 1, k1, j);
               }
            } else if (!par1World.isBlockNormalCube(i1, par3, k1) && (i1 != par5 || par3 - 1 != par6 || k1 != par7)) {
               j = this.getMaxCurrentStrength(par1World, i1, par3 - 1, k1, j);
            }
         }

         if (j > 0) {
            j--;
         } else {
            j = 0;
         }
      }

      if (i != j) {
         par1World.o = true;
         par1World.setBlockMetadataWithNotify(par2, par3, par4, j);
         par1World.markBlocksDirty(par2, par3, par4, par2, par3, par4);
         par1World.o = false;

         for (int l = 0; l < 4; l++) {
            long j1 = par2;
            long l1 = par4;
            int i2 = par3 - 1;
            if (l == 0) {
               j1--;
            }

            if (l == 1) {
               j1++;
            }

            if (l == 2) {
               l1--;
            }

            if (l == 3) {
               l1++;
            }

            if (par1World.isBlockNormalCube(j1, par3, l1)) {
               i2 += 2;
            }

            int j2 = 0;
            j2 = this.getMaxCurrentStrength(par1World, j1, par3, l1, -1);
            j = par1World.getBlockMetadata(par2, par3, par4);
            if (j > 0) {
               j--;
            }

            if (j2 >= 0 && j2 != j) {
               this.calculateCurrentChanges(par1World, j1, par3, l1, par2, par3, par4);
            }

            j2 = this.getMaxCurrentStrength(par1World, j1, i2, l1, -1);
            j = par1World.getBlockMetadata(par2, par3, par4);
            if (j > 0) {
               j--;
            }

            if (j2 >= 0 && j2 != j) {
               this.calculateCurrentChanges(par1World, j1, i2, l1, par2, par3, par4);
            }
         }

         if (i < j || j == 0) {
            this.b.add(new ChunkPosition(par2, par3, par4));
            this.b.add(new ChunkPosition(par2 - 1L, par3, par4));
            this.b.add(new ChunkPosition(par2 + 1L, par3, par4));
            this.b.add(new ChunkPosition(par2, par3 - 1, par4));
            this.b.add(new ChunkPosition(par2, par3 + 1, par4));
            this.b.add(new ChunkPosition(par2, par3, par4 - 1L));
            this.b.add(new ChunkPosition(par2, par3, par4 + 1L));
         }
      }
   }

   private void notifyWireNeighborsOfNeighborChange(World par1World, long par2, int par3, long par4) {
      if (par1World.getBlockId(par2, par3, par4) == this.bO) {
         par1World.notifyBlocksOfNeighborChange(par2, par3, par4, this.bO);
         par1World.notifyBlocksOfNeighborChange(par2 - 1L, par3, par4, this.bO);
         par1World.notifyBlocksOfNeighborChange(par2 + 1L, par3, par4, this.bO);
         par1World.notifyBlocksOfNeighborChange(par2, par3, par4 - 1L, this.bO);
         par1World.notifyBlocksOfNeighborChange(par2, par3, par4 + 1L, this.bO);
         par1World.notifyBlocksOfNeighborChange(par2, par3 - 1, par4, this.bO);
         par1World.notifyBlocksOfNeighborChange(par2, par3 + 1, par4, this.bO);
      }
   }

   @Override
   public void onBlockAdded(World par1World, long par2, int par3, long par4) {
      super.onBlockAdded(par1World, par2, par3, par4);
      if (!par1World.F) {
         this.updateAndPropagateCurrentStrength(par1World, par2, par3, par4);
         par1World.notifyBlocksOfNeighborChange(par2, par3 + 1, par4, this.bO);
         par1World.notifyBlocksOfNeighborChange(par2, par3 - 1, par4, this.bO);
         this.notifyWireNeighborsOfNeighborChange(par1World, par2 - 1L, par3, par4);
         this.notifyWireNeighborsOfNeighborChange(par1World, par2 + 1L, par3, par4);
         this.notifyWireNeighborsOfNeighborChange(par1World, par2, par3, par4 - 1L);
         this.notifyWireNeighborsOfNeighborChange(par1World, par2, par3, par4 + 1L);
         if (par1World.isBlockNormalCube(par2 - 1L, par3, par4)) {
            this.notifyWireNeighborsOfNeighborChange(par1World, par2 - 1L, par3 + 1, par4);
         } else {
            this.notifyWireNeighborsOfNeighborChange(par1World, par2 - 1L, par3 - 1, par4);
         }

         if (par1World.isBlockNormalCube(par2 + 1L, par3, par4)) {
            this.notifyWireNeighborsOfNeighborChange(par1World, par2 + 1L, par3 + 1, par4);
         } else {
            this.notifyWireNeighborsOfNeighborChange(par1World, par2 + 1L, par3 - 1, par4);
         }

         if (par1World.isBlockNormalCube(par2, par3, par4 - 1L)) {
            this.notifyWireNeighborsOfNeighborChange(par1World, par2, par3 + 1, par4 - 1L);
         } else {
            this.notifyWireNeighborsOfNeighborChange(par1World, par2, par3 - 1, par4 - 1L);
         }

         if (par1World.isBlockNormalCube(par2, par3, par4 + 1L)) {
            this.notifyWireNeighborsOfNeighborChange(par1World, par2, par3 + 1, par4 + 1L);
         } else {
            this.notifyWireNeighborsOfNeighborChange(par1World, par2, par3 - 1, par4 + 1L);
         }
      }
   }

   @Override
   public void onBlockRemoval(World par1World, long par2, int par3, long par4) {
      super.onBlockRemoval(par1World, par2, par3, par4);
      if (!par1World.F) {
         par1World.notifyBlocksOfNeighborChange(par2, par3 + 1, par4, this.bO);
         par1World.notifyBlocksOfNeighborChange(par2, par3 - 1, par4, this.bO);
         par1World.notifyBlocksOfNeighborChange(par2 + 1L, par3, par4, this.bO);
         par1World.notifyBlocksOfNeighborChange(par2 - 1L, par3, par4, this.bO);
         par1World.notifyBlocksOfNeighborChange(par2, par3, par4 + 1L, this.bO);
         par1World.notifyBlocksOfNeighborChange(par2, par3, par4 - 1L, this.bO);
         this.updateAndPropagateCurrentStrength(par1World, par2, par3, par4);
         this.notifyWireNeighborsOfNeighborChange(par1World, par2 - 1L, par3, par4);
         this.notifyWireNeighborsOfNeighborChange(par1World, par2 + 1L, par3, par4);
         this.notifyWireNeighborsOfNeighborChange(par1World, par2, par3, par4 - 1L);
         this.notifyWireNeighborsOfNeighborChange(par1World, par2, par3, par4 + 1L);
         if (par1World.isBlockNormalCube(par2 - 1L, par3, par4)) {
            this.notifyWireNeighborsOfNeighborChange(par1World, par2 - 1L, par3 + 1, par4);
         } else {
            this.notifyWireNeighborsOfNeighborChange(par1World, par2 - 1L, par3 - 1, par4);
         }

         if (par1World.isBlockNormalCube(par2 + 1L, par3, par4)) {
            this.notifyWireNeighborsOfNeighborChange(par1World, par2 + 1L, par3 + 1, par4);
         } else {
            this.notifyWireNeighborsOfNeighborChange(par1World, par2 + 1L, par3 - 1, par4);
         }

         if (par1World.isBlockNormalCube(par2, par3, par4 - 1L)) {
            this.notifyWireNeighborsOfNeighborChange(par1World, par2, par3 + 1, par4 - 1L);
         } else {
            this.notifyWireNeighborsOfNeighborChange(par1World, par2, par3 - 1, par4 - 1L);
         }

         if (par1World.isBlockNormalCube(par2, par3, par4 + 1L)) {
            this.notifyWireNeighborsOfNeighborChange(par1World, par2, par3 + 1, par4 + 1L);
         } else {
            this.notifyWireNeighborsOfNeighborChange(par1World, par2, par3 - 1, par4 + 1L);
         }
      }
   }

   private int getMaxCurrentStrength(World par1World, long par2, int par3, long par4, int par5) {
      if (par1World.getBlockId(par2, par3, par4) != this.bO) {
         return par5;
      }

      int i = par1World.getBlockMetadata(par2, par3, par4);
      return i > par5 ? i : par5;
   }

   @Override
   public void onNeighborBlockChange(World par1World, long par2, int par3, long par4, int par5) {
      if (!par1World.F) {
         int i = par1World.getBlockMetadata(par2, par3, par4);
         boolean flag = this.canPlaceBlockAt(par1World, par2, par3, par4);
         if (!flag) {
            this.dropBlockAsItem(par1World, par2, par3, par4, i, 0);
            par1World.setBlockWithNotify(par2, par3, par4, 0);
         } else {
            this.updateAndPropagateCurrentStrength(par1World, par2, par3, par4);
         }

         super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
      }
   }

   @Override
   public int a(int par1, Random par2Random, int par3) {
      return Item.aC.bQ;
   }

   @Override
   public boolean isIndirectlyPoweringTo(World par1World, long par2, int par3, long par4, int par5) {
      return !this.a ? false : this.isPoweringTo(par1World, par2, par3, par4, par5);
   }

   @Override
   public boolean isPoweringTo(IBlockAccess par1IBlockAccess, long par2, int par3, long par4, int par5) {
      if (!this.a) {
         return false;
      }

      if (par1IBlockAccess.getBlockMetadata(par2, par3, par4) == 0) {
         return false;
      }

      if (par5 == 1) {
         return true;
      }

      boolean flag = isPoweredOrRepeater(par1IBlockAccess, par2 - 1L, par3, par4, 1)
         || !par1IBlockAccess.isBlockNormalCube(par2 - 1L, par3, par4) && isPoweredOrRepeater(par1IBlockAccess, par2 - 1L, par3 - 1, par4, -1);
      boolean flag1 = isPoweredOrRepeater(par1IBlockAccess, par2 + 1L, par3, par4, 3)
         || !par1IBlockAccess.isBlockNormalCube(par2 + 1L, par3, par4) && isPoweredOrRepeater(par1IBlockAccess, par2 + 1L, par3 - 1, par4, -1);
      boolean flag2 = isPoweredOrRepeater(par1IBlockAccess, par2, par3, par4 - 1L, 2)
         || !par1IBlockAccess.isBlockNormalCube(par2, par3, par4 - 1L) && isPoweredOrRepeater(par1IBlockAccess, par2, par3 - 1, par4 - 1L, -1);
      boolean flag3 = isPoweredOrRepeater(par1IBlockAccess, par2, par3, par4 + 1L, 0)
         || !par1IBlockAccess.isBlockNormalCube(par2, par3, par4 + 1L) && isPoweredOrRepeater(par1IBlockAccess, par2, par3 - 1, par4 + 1L, -1);
      if (!par1IBlockAccess.isBlockNormalCube(par2, par3 + 1, par4)) {
         if (par1IBlockAccess.isBlockNormalCube(par2 - 1L, par3, par4) && isPoweredOrRepeater(par1IBlockAccess, par2 - 1L, par3 + 1, par4, -1)) {
            flag = true;
         }

         if (par1IBlockAccess.isBlockNormalCube(par2 + 1L, par3, par4) && isPoweredOrRepeater(par1IBlockAccess, par2 + 1L, par3 + 1, par4, -1)) {
            flag1 = true;
         }

         if (par1IBlockAccess.isBlockNormalCube(par2, par3, par4 - 1L) && isPoweredOrRepeater(par1IBlockAccess, par2, par3 + 1, par4 - 1L, -1)) {
            flag2 = true;
         }

         if (par1IBlockAccess.isBlockNormalCube(par2, par3, par4 + 1L) && isPoweredOrRepeater(par1IBlockAccess, par2, par3 + 1, par4 + 1L, -1)) {
            flag3 = true;
         }
      }

      if (!flag2 && !flag1 && !flag && !flag3 && par5 >= 2 && par5 <= 5) {
         return true;
      } else if (par5 == 2 && flag2 && !flag && !flag1) {
         return true;
      } else if (par5 == 3 && flag3 && !flag && !flag1) {
         return true;
      } else {
         return par5 == 4 && flag && !flag2 && !flag3 ? true : par5 == 5 && flag1 && !flag2 && !flag3;
      }
   }

   @Override
   public boolean g() {
      return this.a;
   }

   @Override
   public void randomDisplayTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      int i = par1World.getBlockMetadata(par2, par3, par4);
      if (i > 0) {
         double d = par2 + 0.5 + (par5Random.nextFloat() - 0.5) * 0.2;
         double d1 = par3 + 0.0625F;
         double d2 = par4 + 0.5 + (par5Random.nextFloat() - 0.5) * 0.2;
         float f = i / 15.0F;
         float f1 = f * 0.6F + 0.4F;
         if (i == 0) {
            f1 = 0.0F;
         }

         float f2 = f * f * 0.7F - 0.5F;
         float f3 = f * f * 0.6F - 0.7F;
         if (f2 < 0.0F) {
            f2 = 0.0F;
         }

         if (f3 < 0.0F) {
            f3 = 0.0F;
         }

         par1World.a("reddust", d, d1, d2, f1, f2, f3);
      }
   }

   public static boolean isPowerProviderOrWire(IBlockAccess par0IBlockAccess, long par1, int par2, long par3, int par4) {
      int i = par0IBlockAccess.getBlockId(par1, par2, par3);
      if (i == Block.EntityThrowable.bO) {
         return true;
      }

      if (i == 0) {
         return false;
      }

      if (i != Block.ItemShears.bO && i != Block.bi.bO) {
         return Block.m[i].g() && par4 != -1;
      }

      int j = par0IBlockAccess.getBlockMetadata(par1, par2, par3);
      return par4 == (j & 3) || par4 == aav.e[j & 3];
   }

   public static boolean isPoweredOrRepeater(IBlockAccess par0IBlockAccess, long par1, int par2, long par3, int par4) {
      if (isPowerProviderOrWire(par0IBlockAccess, par1, par2, par3, par4)) {
         return true;
      } else {
         int i = par0IBlockAccess.getBlockId(par1, par2, par3);
         if (i == Block.bi.bO) {
            int j = par0IBlockAccess.getBlockMetadata(par1, par2, par3);
            return par4 == (j & 3);
         } else {
            return false;
         }
      }
   }
}
