import java.util.Random;

public class BlockVine extends Block {
   public BlockVine(int par1) {
      super(par1, 143, acn.k);
      this.a(true);
   }

   @Override
   public void h() {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   @Override
   public int d() {
      return 20;
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
   public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      int i = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
      float f = 1.0F;
      float f1 = 1.0F;
      float f2 = 1.0F;
      float f3 = 0.0F;
      float f4 = 0.0F;
      float f5 = 0.0F;
      boolean flag = i > 0;
      if ((i & 2) != 0) {
         f3 = Math.max(f3, 0.0625F);
         f = 0.0F;
         f1 = 0.0F;
         f4 = 1.0F;
         f2 = 0.0F;
         f5 = 1.0F;
         flag = true;
      }

      if ((i & 8) != 0) {
         f = Math.min(f, 0.9375F);
         f3 = 1.0F;
         f1 = 0.0F;
         f4 = 1.0F;
         f2 = 0.0F;
         f5 = 1.0F;
         flag = true;
      }

      if ((i & 4) != 0) {
         f5 = Math.max(f5, 0.0625F);
         f2 = 0.0F;
         f = 0.0F;
         f3 = 1.0F;
         f1 = 0.0F;
         f4 = 1.0F;
         flag = true;
      }

      if ((i & 1) != 0) {
         f2 = Math.min(f2, 0.9375F);
         f5 = 1.0F;
         f = 0.0F;
         f3 = 1.0F;
         f1 = 0.0F;
         f4 = 1.0F;
         flag = true;
      }

      if (!flag && this.e(par1IBlockAccess.getBlockId(par2, par3 + 1, par4))) {
         f1 = Math.min(f1, 0.9375F);
         f4 = 1.0F;
         f = 0.0F;
         f3 = 1.0F;
         f2 = 0.0F;
         f5 = 1.0F;
      }

      this.a(f, f1, f2, f3, f4, f5);
   }

   @Override
   public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, long par2, int par3, long i) {
      return null;
   }

   @Override
   public boolean canPlaceBlockOnSide(World par1World, long par2, int par3, long par4, int par5) {
      switch (par5) {
         case 1:
            return this.e(par1World.getBlockId(par2, par3 + 1, par4));
         case 2:
            return this.e(par1World.getBlockId(par2, par3, par4 + 1L));
         case 3:
            return this.e(par1World.getBlockId(par2, par3, par4 - 1L));
         case 4:
            return this.e(par1World.getBlockId(par2 + 1L, par3, par4));
         case 5:
            return this.e(par1World.getBlockId(par2 - 1L, par3, par4));
         default:
            return false;
      }
   }

   private boolean e(int par1) {
      if (par1 == 0) {
         return false;
      }

      Block block = Block.m[par1];
      return block.b() && block.cd.c();
   }

   private boolean canVineStay(World par1World, long par2, int par3, long par4) {
      int i = par1World.getBlockMetadata(par2, par3, par4);
      int j = i;
      if (j > 0) {
         for (int k = 0; k <= 3; k++) {
            int l = 1 << k;
            if ((i & l) != 0
               && !this.e(par1World.getBlockId(par2 + aav.a[k], par3, par4 + aav.b[k]))
               && (par1World.getBlockId(par2, par3 + 1, par4) != this.bO || (par1World.getBlockMetadata(par2, par3 + 1, par4) & l) == 0)) {
               j &= ~l;
            }
         }
      }

      if (j == 0 && !this.e(par1World.getBlockId(par2, par3 + 1, par4))) {
         return false;
      }

      if (j != i) {
         par1World.setBlockMetadataWithNotify(par2, par3, par4, j);
      }

      return true;
   }

   @Override
   public int i() {
      return ColorizerFoliage.c();
   }

   @Override
   public int d(int par1) {
      return ColorizerFoliage.c();
   }

   @Override
   public int colorMultiplier(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      return par1IBlockAccess.getBiomeGenForCoords(par2, par4).l();
   }

   @Override
   public void onNeighborBlockChange(World par1World, long par2, int par3, long par4, int par5) {
      if (!par1World.F && !this.canVineStay(par1World, par2, par3, par4)) {
         this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
         par1World.setBlockWithNotify(par2, par3, par4, 0);
      }
   }

   @Override
   public void updateTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      if (!par1World.F && par1World.r.nextInt(4) == 0) {
         byte byte0 = 4;
         int i = 5;
         boolean flag = false;

         label143:
         for (long jLong = par2 - byte0; jLong <= par2 + byte0; jLong++) {
            for (long k = par4 - byte0; k <= par4 + byte0; k++) {
               for (int i1 = par3 - 1; i1 <= par3 + 1; i1++) {
                  if (par1World.getBlockId(jLong, i1, k) == this.bO) {
                     if (--i <= 0) {
                        flag = true;
                        break label143;
                     }
                  }
               }
            }
         }

         int j = par1World.getBlockMetadata(par2, par3, par4);
         int l = par1World.r.nextInt(6);
         int j1 = aav.d[l];
         if (l == 1 && par3 < 255 && par1World.isAirBlock(par2, par3 + 1, par4)) {
            if (flag) {
               return;
            }

            int k1 = par1World.r.nextInt(16) & j;
            if (k1 > 0) {
               for (int j2 = 0; j2 <= 3; j2++) {
                  if (!this.e(par1World.getBlockId(par2 + aav.a[j2], par3 + 1, par4 + aav.b[j2]))) {
                     k1 &= ~(1 << j2);
                  }
               }

               if (k1 > 0) {
                  par1World.setBlockAndMetadataWithNotify(par2, par3 + 1, par4, this.bO, k1);
               }
            }
         } else if (l >= 2 && l <= 5 && (j & 1 << j1) == 0) {
            if (flag) {
               return;
            }

            int l1 = par1World.getBlockId(par2 + aav.a[j1], par3, par4 + aav.b[j1]);
            if (l1 == 0 || Block.m[l1] == null) {
               int k2 = j1 + 1 & 3;
               int j3 = j1 + 3 & 3;
               if ((j & 1 << k2) != 0 && this.e(par1World.getBlockId(par2 + aav.a[j1] + aav.a[k2], par3, par4 + aav.b[j1] + aav.b[k2]))) {
                  par1World.setBlockAndMetadataWithNotify(par2 + aav.a[j1], par3, par4 + aav.b[j1], this.bO, 1 << k2);
               } else if ((j & 1 << j3) != 0 && this.e(par1World.getBlockId(par2 + aav.a[j1] + aav.a[j3], par3, par4 + aav.b[j1] + aav.b[j3]))) {
                  par1World.setBlockAndMetadataWithNotify(par2 + aav.a[j1], par3, par4 + aav.b[j1], this.bO, 1 << j3);
               } else if ((j & 1 << k2) != 0
                  && par1World.isAirBlock(par2 + aav.a[j1] + aav.a[k2], par3, par4 + aav.b[j1] + aav.b[k2])
                  && this.e(par1World.getBlockId(par2 + aav.a[k2], par3, par4 + aav.b[k2]))) {
                  par1World.setBlockAndMetadataWithNotify(par2 + aav.a[j1] + aav.a[k2], par3, par4 + aav.b[j1] + aav.b[k2], this.bO, 1 << (j1 + 2 & 3));
               } else if ((j & 1 << j3) != 0
                  && par1World.isAirBlock(par2 + aav.a[j1] + aav.a[j3], par3, par4 + aav.b[j1] + aav.b[j3])
                  && this.e(par1World.getBlockId(par2 + aav.a[j3], par3, par4 + aav.b[j3]))) {
                  par1World.setBlockAndMetadataWithNotify(par2 + aav.a[j1] + aav.a[j3], par3, par4 + aav.b[j1] + aav.b[j3], this.bO, 1 << (j1 + 2 & 3));
               } else if (this.e(par1World.getBlockId(par2 + aav.a[j1], par3 + 1, par4 + aav.b[j1]))) {
                  par1World.setBlockAndMetadataWithNotify(par2 + aav.a[j1], par3, par4 + aav.b[j1], this.bO, 0);
               }
            } else if (Block.m[l1].cd.j() && Block.m[l1].b()) {
               par1World.setBlockMetadataWithNotify(par2, par3, par4, j | 1 << j1);
            }
         } else if (par3 > 1) {
            int i2 = par1World.getBlockId(par2, par3 - 1, par4);
            if (i2 == 0) {
               int l2 = par1World.r.nextInt(16) & j;
               if (l2 > 0) {
                  par1World.setBlockAndMetadataWithNotify(par2, par3 - 1, par4, this.bO, l2);
               }
            } else if (i2 == this.bO) {
               int i3 = par1World.r.nextInt(16) & j;
               int k3 = par1World.getBlockMetadata(par2, par3 - 1, par4);
               if (k3 != (k3 | i3)) {
                  par1World.setBlockMetadataWithNotify(par2, par3 - 1, par4, k3 | i3);
               }
            }
         }
      }
   }

   @Override
   public void onBlockPlaced(World par1World, long par2, int par3, long par4, int par5) {
      byte byte0 = 0;
      switch (par5) {
         case 2:
            byte0 = 1;
            break;
         case 3:
            byte0 = 4;
            break;
         case 4:
            byte0 = 8;
            break;
         case 5:
            byte0 = 2;
      }

      if (byte0 != 0) {
         par1World.setBlockMetadataWithNotify(par2, par3, par4, byte0);
      }
   }

   @Override
   public int a(int par1, Random par2Random, int par3) {
      return 0;
   }

   @Override
   public int a(Random par1Random) {
      return 0;
   }

   @Override
   public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, long par3, int par4, long par5, int par6) {
      if (!par1World.F && par2EntityPlayer.EntityThrowable() != null && par2EntityPlayer.EntityThrowable().c == Item.be.bQ) {
         par2EntityPlayer.a(gv.C[this.bO], 1);
         this.dropBlockAsItem_do(par1World, par3, par4, par5, new ItemStack(Block.bu, 1, 0));
      } else {
         super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
      }
   }
}
