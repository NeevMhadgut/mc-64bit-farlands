import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockRedstoneTorch extends BlockTorch {
   private boolean a = false;
   private static List b = new ArrayList();

   @Override
   public int a(int par1, int par2) {
      return par1 == 1 ? Block.EntityThrowable.a(par1, par2) : super.a(par1, par2);
   }

   private boolean checkForBurnout(World par1World, long par2, int par3, long par4, boolean par5) {
      if (par5) {
         b.add(new RedstoneUpdateInfo(par2, par3, par4, par1World.w()));
      }

      int i = 0;

      for (int j = 0; j < b.size(); j++) {
         RedstoneUpdateInfo redstoneupdateinfo = (RedstoneUpdateInfo)b.get(j);
         if (redstoneupdateinfo.a == par2 && redstoneupdateinfo.b == par3 && redstoneupdateinfo.c == par4) {
            if (++i >= 8) {
               return true;
            }
         }
      }

      return false;
   }

   protected BlockRedstoneTorch(int par1, int par2, boolean par3) {
      super(par1, par2);
      this.a = par3;
      this.a(true);
   }

   @Override
   public int e() {
      return 2;
   }

   @Override
   public void onBlockAdded(World par1World, long par2, int par3, long par4) {
      if (par1World.getBlockMetadata(par2, par3, par4) == 0) {
         super.onBlockAdded(par1World, par2, par3, par4);
      }

      if (this.a) {
         par1World.notifyBlocksOfNeighborChange(par2, par3 - 1, par4, this.bO);
         par1World.notifyBlocksOfNeighborChange(par2, par3 + 1, par4, this.bO);
         par1World.notifyBlocksOfNeighborChange(par2 - 1L, par3, par4, this.bO);
         par1World.notifyBlocksOfNeighborChange(par2 + 1L, par3, par4, this.bO);
         par1World.notifyBlocksOfNeighborChange(par2, par3, par4 - 1L, this.bO);
         par1World.notifyBlocksOfNeighborChange(par2, par3, par4 + 1L, this.bO);
      }
   }

   @Override
   public void onBlockRemoval(World par1World, long par2, int par3, long par4) {
      if (this.a) {
         par1World.notifyBlocksOfNeighborChange(par2, par3 - 1, par4, this.bO);
         par1World.notifyBlocksOfNeighborChange(par2, par3 + 1, par4, this.bO);
         par1World.notifyBlocksOfNeighborChange(par2 - 1L, par3, par4, this.bO);
         par1World.notifyBlocksOfNeighborChange(par2 + 1L, par3, par4, this.bO);
         par1World.notifyBlocksOfNeighborChange(par2, par3, par4 - 1L, this.bO);
         par1World.notifyBlocksOfNeighborChange(par2, par3, par4 + 1L, this.bO);
      }
   }

   @Override
   public boolean isPoweringTo(IBlockAccess par1IBlockAccess, long par2, int par3, long par4, int par5) {
      if (!this.a) {
         return false;
      } else {
         int i = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
         if (i == 5 && par5 == 1) {
            return false;
         } else if (i == 3 && par5 == 3) {
            return false;
         } else if (i == 4 && par5 == 2) {
            return false;
         } else {
            return i == 1 && par5 == 5 ? false : i != 2 || par5 != 4;
         }
      }
   }

   private boolean isIndirectlyPowered(World par1World, long par2, int par3, long par4) {
      int i = par1World.getBlockMetadata(par2, par3, par4);
      if (i == 5 && par1World.isBlockIndirectlyProvidingPowerTo(par2, par3 - 1, par4, 0)) {
         return true;
      } else if (i == 3 && par1World.isBlockIndirectlyProvidingPowerTo(par2, par3, par4 - 1L, 2)) {
         return true;
      } else if (i == 4 && par1World.isBlockIndirectlyProvidingPowerTo(par2, par3, par4 + 1L, 3)) {
         return true;
      } else {
         return i == 1 && par1World.isBlockIndirectlyProvidingPowerTo(par2 - 1L, par3, par4, 4)
            ? true
            : i == 2 && par1World.isBlockIndirectlyProvidingPowerTo(par2 + 1L, par3, par4, 5);
      }
   }

   @Override
   public void updateTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      boolean flag = this.isIndirectlyPowered(par1World, par2, par3, par4);

      while (b.size() > 0 && par1World.w() - ((RedstoneUpdateInfo)b.get(0)).d > 60L) {
         b.remove(0);
      }

      if (this.a) {
         if (flag) {
            par1World.setBlockAndMetadataWithNotify(par2, par3, par4, Block.aP.bO, par1World.getBlockMetadata(par2, par3, par4));
            if (this.checkForBurnout(par1World, par2, par3, par4, true)) {
               par1World.a(par2 + 0.5, par3 + 0.5, par4 + 0.5, "random.fizz", 0.5F, 2.6F + (par1World.r.nextFloat() - par1World.r.nextFloat()) * 0.8F);
               int i2 = par1World.getBlockMetadata(par2, par3, par4);
               double dummy = par2 + 0.5;
               double dummy1 = par3 + 0.7;
               double dummy2 = par4 + 0.5;
               if (i2 >= 1 && i2 <= 4) {
                  dummy1 += 0.22;
                  if (i2 == 1) {
                     dummy -= 0.27;
                  } else if (i2 == 2) {
                     dummy += 0.27;
                  } else if (i2 == 3) {
                     dummy2 -= 0.27;
                  } else if (i2 == 4) {
                     dummy2 += 0.27;
                  }
               }

               for (int i = 0; i < 5; i++) {
                  double d = dummy + par5Random.nextDouble() * 0.5 - 0.25;
                  double d1 = dummy1 + par5Random.nextDouble() * 0.5 - 0.25;
                  double d2 = dummy2 + par5Random.nextDouble() * 0.5 - 0.25;
                  par1World.a("smoke", d, d1, d2, 0.0, 0.0, 0.0);
               }
            }
         }
      } else if (!flag && !this.checkForBurnout(par1World, par2, par3, par4, false)) {
         par1World.setBlockAndMetadataWithNotify(par2, par3, par4, Block.aQ.bO, par1World.getBlockMetadata(par2, par3, par4));
      }
   }

   @Override
   public void onNeighborBlockChange(World par1World, long par2, int par3, long par4, int par5) {
      super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
      par1World.scheduleBlockUpdate(par2, par3, par4, this.bO, this.e());
   }

   @Override
   public boolean isIndirectlyPoweringTo(World par1World, long par2, int par3, long par4, int par5) {
      return par5 == 0 ? this.isPoweringTo(par1World, par2, par3, par4, par5) : false;
   }

   @Override
   public int a(int par1, Random par2Random, int par3) {
      return Block.aQ.bO;
   }

   @Override
   public boolean g() {
      return true;
   }

   @Override
   public void randomDisplayTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      if (this.a) {
         int i = par1World.getBlockMetadata(par2, par3, par4);
         double d = par2 + 0.5 + (par5Random.nextFloat() - 0.5F) * 0.2;
         double d1 = par3 + 0.7 + (par5Random.nextFloat() - 0.5F) * 0.2;
         double d2 = par4 + 0.5 + (par5Random.nextFloat() - 0.5F) * 0.2;
         double d3 = 0.22F;
         double d4 = 0.27F;
         if (i == 1) {
            par1World.a("reddust", d - d4, d1 + d3, d2, 0.0, 0.0, 0.0);
         } else if (i == 2) {
            par1World.a("reddust", d + d4, d1 + d3, d2, 0.0, 0.0, 0.0);
         } else if (i == 3) {
            par1World.a("reddust", d, d1 + d3, d2 - d4, 0.0, 0.0, 0.0);
         } else if (i == 4) {
            par1World.a("reddust", d, d1 + d3, d2 + d4, 0.0, 0.0, 0.0);
         } else {
            par1World.a("reddust", d, d1, d2, 0.0, 0.0, 0.0);
         }
      }
   }
}
