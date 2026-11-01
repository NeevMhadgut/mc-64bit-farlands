import java.util.Random;

public class BlockRedstoneRepeater extends w {
   public static final double[] a = new double[]{-0.0625, 0.0625, 0.1875, 0.3125};
   private static final int[] b = new int[]{1, 2, 3, 4};
   private final boolean c;

   protected BlockRedstoneRepeater(int par1, boolean par2) {
      super(par1, 6, acn.p);
      this.c = par2;
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
   }

   public boolean b() {
      return false;
   }

   public boolean canPlaceBlockAt(World par1World, long par2, int par3, long par4) {
      return !par1World.isBlockNormalCube(par2, par3 - 1, par4) ? false : super.canPlaceBlockAt(par1World, par2, par3, par4);
   }

   public boolean canBlockStay(World par1World, long par2, int par3, long par4) {
      return !par1World.isBlockNormalCube(par2, par3 - 1, par4) ? false : super.canBlockStay(par1World, par2, par3, par4);
   }

   public void updateTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      int i = par1World.getBlockMetadata(par2, par3, par4);
      boolean flag = this.ignoreTick(par1World, par2, par3, par4, i);
      if (this.c && !flag) {
         par1World.setBlockAndMetadataWithNotify(par2, par3, par4, Block.ItemShears.bO, i);
      } else if (!this.c) {
         par1World.setBlockAndMetadataWithNotify(par2, par3, par4, Block.bi.bO, i);
         if (!flag) {
            int j = (i & 12) >> 2;
            par1World.scheduleBlockUpdate(par2, par3, par4, Block.bi.bO, b[j] * 2);
         }
      }
   }

   public int a(int par1, int par2) {
      if (par1 == 0) {
         return !this.c ? 115 : 99;
      } else if (par1 == 1) {
         return !this.c ? 131 : 147;
      } else {
         return 5;
      }
   }

   public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, long par2, int par3, long par4, int par5) {
      return par5 != 0 && par5 != 1;
   }

   public int d() {
      return 15;
   }

   public int a_(int par1) {
      return this.a(par1, 0);
   }

   public boolean isIndirectlyPoweringTo(World par1World, long par2, int par3, long par4, int par5) {
      return this.isPoweringTo(par1World, par2, par3, par4, par5);
   }

   public boolean isPoweringTo(IBlockAccess par1IBlockAccess, long par2, int par3, long par4, int par5) {
      if (!this.c) {
         return false;
      } else {
         int i = a(par1IBlockAccess.getBlockMetadata(par2, par3, par4));
         if (i == 0 && par5 == 3) {
            return true;
         } else if (i == 1 && par5 == 4) {
            return true;
         } else {
            return i == 2 && par5 == 2 ? true : i == 3 && par5 == 5;
         }
      }
   }

   public void onNeighborBlockChange(World par1World, long par2, int par3, long par4, int par5) {
      if (!this.canBlockStay(par1World, par2, par3, par4)) {
         this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
         par1World.setBlockWithNotify(par2, par3, par4, 0);
         par1World.notifyBlocksOfNeighborChange(par2 + 1L, par3, par4, this.bO);
         par1World.notifyBlocksOfNeighborChange(par2 - 1L, par3, par4, this.bO);
         par1World.notifyBlocksOfNeighborChange(par2, par3, par4 + 1L, this.bO);
         par1World.notifyBlocksOfNeighborChange(par2, par3, par4 - 1L, this.bO);
         par1World.notifyBlocksOfNeighborChange(par2, par3 - 1, par4, this.bO);
         par1World.notifyBlocksOfNeighborChange(par2, par3 + 1, par4, this.bO);
      } else {
         int i = par1World.getBlockMetadata(par2, par3, par4);
         boolean flag = this.ignoreTick(par1World, par2, par3, par4, i);
         int j = (i & 12) >> 2;
         if (this.c && !flag) {
            par1World.scheduleBlockUpdate(par2, par3, par4, this.bO, b[j] * 2);
         } else if (!this.c && flag) {
            par1World.scheduleBlockUpdate(par2, par3, par4, this.bO, b[j] * 2);
         }
      }
   }

   private boolean ignoreTick(World par1World, long par2, int par3, long par4, int par5) {
      int i = a(par5);
      switch (i) {
         case 0:
            return par1World.isBlockIndirectlyProvidingPowerTo(par2, par3, par4 + 1L, 3)
               || par1World.getBlockId(par2, par3, par4 + 1L) == Block.EntityThrowable.bO && par1World.getBlockMetadata(par2, par3, par4 + 1L) > 0;
         case 1:
            return par1World.isBlockIndirectlyProvidingPowerTo(par2 - 1L, par3, par4, 4)
               || par1World.getBlockId(par2 - 1L, par3, par4) == Block.EntityThrowable.bO && par1World.getBlockMetadata(par2 - 1L, par3, par4) > 0;
         case 2:
            return par1World.isBlockIndirectlyProvidingPowerTo(par2, par3, par4 - 1L, 2)
               || par1World.getBlockId(par2, par3, par4 - 1L) == Block.EntityThrowable.bO && par1World.getBlockMetadata(par2, par3, par4 - 1L) > 0;
         case 3:
            return par1World.isBlockIndirectlyProvidingPowerTo(par2 + 1L, par3, par4, 5)
               || par1World.getBlockId(par2 + 1L, par3, par4) == Block.EntityThrowable.bO && par1World.getBlockMetadata(par2 + 1L, par3, par4) > 0;
         default:
            return false;
      }
   }

   public boolean blockActivated(World par1World, long par2, int par3, long par4, EntityPlayer par5EntityPlayer) {
      int i = par1World.getBlockMetadata(par2, par3, par4);
      int j = (i & 12) >> 2;
      j = j + 1 << 2 & 12;
      par1World.setBlockMetadataWithNotify(par2, par3, par4, j | i & 3);
      return true;
   }

   public boolean g() {
      return true;
   }

   public void onBlockPlacedBy(World par1World, long par2, int par3, long par4, EntityLiving par5EntityLiving) {
      int i = ((MathHelper.c(par5EntityLiving.u * 4.0F / 360.0F + 0.5) & 3) + 2) % 4;
      par1World.setBlockMetadataWithNotify(par2, par3, par4, i);
      boolean flag = this.ignoreTick(par1World, par2, par3, par4, i);
      if (flag) {
         par1World.scheduleBlockUpdate(par2, par3, par4, this.bO, 1);
      }
   }

   public void onBlockAdded(World par1World, long par2, int par3, long par4) {
      par1World.notifyBlocksOfNeighborChange(par2 + 1L, par3, par4, this.bO);
      par1World.notifyBlocksOfNeighborChange(par2 - 1L, par3, par4, this.bO);
      par1World.notifyBlocksOfNeighborChange(par2, par3, par4 + 1L, this.bO);
      par1World.notifyBlocksOfNeighborChange(par2, par3, par4 - 1L, this.bO);
      par1World.notifyBlocksOfNeighborChange(par2, par3 - 1, par4, this.bO);
      par1World.notifyBlocksOfNeighborChange(par2, par3 + 1, par4, this.bO);
   }

   public void onBlockDestroyedByPlayer(World par1World, long par2, int par3, long par4, int par5) {
      if (this.c) {
         par1World.notifyBlocksOfNeighborChange(par2 + 1L, par3, par4, this.bO);
         par1World.notifyBlocksOfNeighborChange(par2 - 1L, par3, par4, this.bO);
         par1World.notifyBlocksOfNeighborChange(par2, par3, par4 + 1L, this.bO);
         par1World.notifyBlocksOfNeighborChange(par2, par3, par4 - 1L, this.bO);
         par1World.notifyBlocksOfNeighborChange(par2, par3 - 1, par4, this.bO);
         par1World.notifyBlocksOfNeighborChange(par2, par3 + 1, par4, this.bO);
      }

      super.onBlockDestroyedByPlayer(par1World, par2, par3, par4, par5);
   }

   public boolean a() {
      return false;
   }

   public int a(int par1, Random par2Random, int par3) {
      return Item.ItemBucket.bQ;
   }

   public void randomDisplayTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      if (this.c) {
         int i = par1World.getBlockMetadata(par2, par3, par4);
         int j = a(i);
         double d = par2 + 0.5 + (par5Random.nextFloat() - 0.5F) * 0.2;
         double d1 = par3 + 0.4 + (par5Random.nextFloat() - 0.5F) * 0.2;
         double d2 = par4 + 0.5 + (par5Random.nextFloat() - 0.5F) * 0.2;
         double d3 = 0.0;
         double d4 = 0.0;
         if (par5Random.nextInt(2) == 0) {
            switch (j) {
               case 0:
                  d4 = -0.3125;
                  break;
               case 1:
                  d3 = 0.3125;
                  break;
               case 2:
                  d4 = 0.3125;
                  break;
               case 3:
                  d3 = -0.3125;
            }
         } else {
            int k = (i & 12) >> 2;
            switch (j) {
               case 0:
                  d4 = a[k];
                  break;
               case 1:
                  d3 = -a[k];
                  break;
               case 2:
                  d4 = -a[k];
                  break;
               case 3:
                  d3 = a[k];
            }
         }

         par1World.a("reddust", d + d3, d1, d2 + d4, 0.0, 0.0, 0.0);
      }
   }
}
