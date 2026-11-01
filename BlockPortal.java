import java.util.Random;

public class BlockPortal extends BlockBreakable {
   public BlockPortal(int par1, int par2) {
      super(par1, par2, acn.B, false);
   }

   @Override
   public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, long par2, int par3, long i) {
      return null;
   }

   @Override
   public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      if (par1IBlockAccess.getBlockId(par2 - 1L, par3, par4) != this.bO && par1IBlockAccess.getBlockId(par2 + 1L, par3, par4) != this.bO) {
         float f1 = 0.125F;
         float f3 = 0.5F;
         this.a(0.5F - f1, 0.0F, 0.5F - f3, 0.5F + f1, 1.0F, 0.5F + f3);
      } else {
         float f = 0.5F;
         float f2 = 0.125F;
         this.a(0.5F - f, 0.0F, 0.5F - f2, 0.5F + f, 1.0F, 0.5F + f2);
      }
   }

   @Override
   public boolean a() {
      return false;
   }

   @Override
   public boolean b() {
      return false;
   }

   public boolean tryToCreatePortal(World par1World, long par2, int par3, long par4) {
      int i = 0;
      int j = 0;
      if (par1World.getBlockId(par2 - 1L, par3, par4) == Block.ap.bO || par1World.getBlockId(par2 + 1L, par3, par4) == Block.ap.bO) {
         i = 1;
      }

      if (par1World.getBlockId(par2, par3, par4 - 1L) == Block.ap.bO || par1World.getBlockId(par2, par3, par4 + 1L) == Block.ap.bO) {
         j = 1;
      }

      if (i == j) {
         return false;
      }

      if (par1World.getBlockId(par2 - i, par3, par4 - j) == 0) {
         par2 -= i;
         par4 -= j;
      }

      for (int k = -1; k <= 2; k++) {
         for (int i1 = -1; i1 <= 3; i1++) {
            boolean flag = k == -1 || k == 2 || i1 == -1 || i1 == 3;
            if (k != -1 && k != 2 || i1 != -1 && i1 != 3) {
               int k1 = par1World.getBlockId(par2 + i * k, par3 + i1, par4 + j * k);
               if (flag) {
                  if (k1 != Block.ap.bO) {
                     return false;
                  }
               } else if (k1 != 0 && k1 != Block.ar.bO) {
                  return false;
               }
            }
         }
      }

      par1World.o = true;

      for (int l = 0; l < 2; l++) {
         for (int j1 = 0; j1 < 3; j1++) {
            par1World.setBlockWithNotify(par2 + i * l, par3 + j1, par4 + j * l, Block.be.bO);
         }
      }

      par1World.o = false;
      return true;
   }

   @Override
   public void onNeighborBlockChange(World par1World, long par2, int par3, long par4, int par5) {
      int i = 0;
      int j = 1;
      if (par1World.getBlockId(par2 - 1L, par3, par4) == this.bO || par1World.getBlockId(par2 + 1L, par3, par4) == this.bO) {
         i = 1;
         j = 0;
      }

      int k = par3;

      while (par1World.getBlockId(par2, k - 1, par4) == this.bO) {
         k--;
      }

      if (par1World.getBlockId(par2, k - 1, par4) != Block.ap.bO) {
         par1World.setBlockWithNotify(par2, par3, par4, 0);
      } else {
         int l = 1;

         while (l < 4 && par1World.getBlockId(par2, k + l, par4) == this.bO) {
            l++;
         }

         if (l == 3 && par1World.getBlockId(par2, k + l, par4) == Block.ap.bO) {
            boolean flag = par1World.getBlockId(par2 - 1L, par3, par4) == this.bO || par1World.getBlockId(par2 + 1L, par3, par4) == this.bO;
            boolean flag1 = par1World.getBlockId(par2, par3, par4 - 1L) == this.bO || par1World.getBlockId(par2, par3, par4 + 1L) == this.bO;
            if (flag && flag1) {
               par1World.setBlockWithNotify(par2, par3, par4, 0);
            } else if ((par1World.getBlockId(par2 + i, par3, par4 + j) != Block.ap.bO || par1World.getBlockId(par2 - i, par3, par4 - j) != this.bO)
               && (par1World.getBlockId(par2 - i, par3, par4 - j) != Block.ap.bO || par1World.getBlockId(par2 + i, par3, par4 + j) != this.bO)) {
               par1World.setBlockWithNotify(par2, par3, par4, 0);
            }
         } else {
            par1World.setBlockWithNotify(par2, par3, par4, 0);
         }
      }
   }

   @Override
   public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, long par2, int par3, long par4, int par5) {
      if (par1IBlockAccess.getBlockId(par2, par3, par4) == this.bO) {
         return false;
      } else {
         boolean flag = par1IBlockAccess.getBlockId(par2 - 1L, par3, par4) == this.bO && par1IBlockAccess.getBlockId(par2 - 2L, par3, par4) != this.bO;
         boolean flag1 = par1IBlockAccess.getBlockId(par2 + 1L, par3, par4) == this.bO && par1IBlockAccess.getBlockId(par2 + 2L, par3, par4) != this.bO;
         boolean flag2 = par1IBlockAccess.getBlockId(par2, par3, par4 - 1L) == this.bO && par1IBlockAccess.getBlockId(par2, par3, par4 - 2L) != this.bO;
         boolean flag3 = par1IBlockAccess.getBlockId(par2, par3, par4 + 1L) == this.bO && par1IBlockAccess.getBlockId(par2, par3, par4 + 2L) != this.bO;
         boolean flag4 = flag || flag1;
         boolean flag5 = flag2 || flag3;
         if (flag4 && par5 == 4) {
            return true;
         } else if (flag4 && par5 == 5) {
            return true;
         } else {
            return flag5 && par5 == 2 ? true : flag5 && par5 == 3;
         }
      }
   }

   @Override
   public int a(Random par1Random) {
      return 0;
   }

   @Override
   public int c() {
      return 1;
   }

   @Override
   public void onEntityCollidedWithBlock(World par1World, long par2, int par3, long par4, Entity par5Entity) {
      if (par5Entity.j == null && par5Entity.i == null) {
         par5Entity.R();
      }
   }

   @Override
   public void randomDisplayTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      if (par5Random.nextInt(100) == 0) {
         par1World.a(par2 + 0.5, par3 + 0.5, par4 + 0.5, "portal.portal", 0.5F, par5Random.nextFloat() * 0.4F + 0.8F);
      }

      for (int i = 0; i < 4; i++) {
         double d = par2 + par5Random.nextDouble();
         double d1 = par3 + par5Random.nextDouble();
         double d2 = par4 + par5Random.nextDouble();
         double d3 = 0.0;
         double d4 = 0.0;
         double d5 = 0.0;
         int j = par5Random.nextInt(2) * 2 - 1;
         d3 = (par5Random.nextFloat() - 0.5) * 0.5;
         d4 = (par5Random.nextFloat() - 0.5) * 0.5;
         d5 = (par5Random.nextFloat() - 0.5) * 0.5;
         if (par1World.getBlockId(par2 - 1L, par3, par4) != this.bO && par1World.getBlockId(par2 + 1L, par3, par4) != this.bO) {
            d = par2 + 0.5 + 0.25 * j;
            d3 = par5Random.nextFloat() * 2.0F * j;
         } else {
            d2 = par4 + 0.5 + 0.25 * j;
            d5 = par5Random.nextFloat() * 2.0F * j;
         }

         par1World.a("portal", d, d1, d2, d3, d4, d5);
      }
   }
}
