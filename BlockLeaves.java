import java.util.Random;

public class BlockLeaves extends BlockLeavesBase {
   private int c;
   int[] b;

   protected BlockLeaves(int par1, int par2) {
      super(par1, par2, acn.i, false);
      this.c = par2;
      this.a(true);
   }

   @Override
   public int i() {
      double d = 0.5;
      double d1 = 1.0;
      return ColorizerFoliage.a(d, d1);
   }

   @Override
   public int d(int par1) {
      if ((par1 & 3) == 1) {
         return ColorizerFoliage.a();
      } else {
         return (par1 & 3) == 2 ? ColorizerFoliage.b() : ColorizerFoliage.c();
      }
   }

   @Override
   public int colorMultiplier(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      int i = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
      if ((i & 3) == 1) {
         return ColorizerFoliage.a();
      }

      if ((i & 3) == 2) {
         return ColorizerFoliage.b();
      }

      int j = 0;
      int k = 0;
      int l = 0;

      for (int i1 = -1; i1 <= 1; i1++) {
         for (int j1 = -1; j1 <= 1; j1++) {
            int k1 = par1IBlockAccess.getBiomeGenForCoords(par2 + j1, par4 + i1).l();
            j += (k1 & 0xFF0000) >> 16;
            k += (k1 & 0xFF00) >> 8;
            l += k1 & 0xFF;
         }
      }

      return (j / 9 & 0xFF) << 16 | (k / 9 & 0xFF) << 8 | l / 9 & 0xFF;
   }

   @Override
   public void onBlockRemoval(World par1World, long par2, int par3, long par4) {
      int i = 1;
      int j = i + 1;
      if (par1World.checkChunksExist(par2 - j, par3 - j, par4 - j, par2 + j, par3 + j, par4 + j)) {
         for (int k = -i; k <= i; k++) {
            for (int l = -i; l <= i; l++) {
               for (int i1 = -i; i1 <= i; i1++) {
                  int j1 = par1World.getBlockId(par2 + k, par3 + l, par4 + i1);
                  if (j1 == Block.K.bO) {
                     int k1 = par1World.getBlockMetadata(par2 + k, par3 + l, par4 + i1);
                     par1World.setBlockMetadata(par2 + k, par3 + l, par4 + i1, k1 | 8);
                  }
               }
            }
         }
      }
   }

   @Override
   public void updateTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      if (!par1World.F) {
         int i = par1World.getBlockMetadata(par2, par3, par4);
         int j = 4;
         if (par1World.checkChunksExist(par2 - j, par3 - j, par4 - j, par2 + j, par3 + j, par4 + j)) {
            for (long i1 = par2 - j; i1 <= par2 + j; i1++) {
               for (int j1 = par3 - j; j1 <= par3 + j; j1++) {
                  for (long k1 = par4 - j; k1 <= par4 + j; k1++) {
                     if (par1World.getBlockId(i1, j1, k1) == Block.J.bO) {
                        return;
                     }
                  }
               }
            }

            this.removeLeaves(par1World, par2, par3, par4);
         }
      }
   }

   private void removeLeaves(World par1World, long par2, int par3, long par4) {
      this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
      par1World.setBlockWithNotify(par2, par3, par4, 0);
   }

   @Override
   public int a(Random par1Random) {
      return par1Random.nextInt(20) != 0 ? 0 : 1;
   }

   @Override
   public int a(int par1, Random par2Random, int par3) {
      return Block.y.bO;
   }

   @Override
   public void dropBlockAsItemWithChance(World par1World, long par2, int par3, long par4, int par5, float par6, int par7) {
      if (!par1World.F) {
         byte byte0 = 20;
         if ((par5 & 3) == 3) {
            byte0 = 40;
         }

         if (par1World.r.nextInt(byte0) == 0) {
            int i = this.a(par5, par1World.r, par7);
            this.dropBlockAsItem_do(par1World, par2, par3, par4, new ItemStack(i, 1, this.c(par5)));
         }

         if ((par5 & 3) == 0 && par1World.r.nextInt(200) == 0) {
            this.dropBlockAsItem_do(par1World, par2, par3, par4, new ItemStack(Item.j, 1, 0));
         }
      }
   }

   @Override
   public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, long par3, int par4, long par5, int par6) {
      if (!par1World.F && par2EntityPlayer.EntityThrowable() != null && par2EntityPlayer.EntityThrowable().c == Item.be.bQ) {
         par2EntityPlayer.a(gv.C[this.bO], 1);
         this.dropBlockAsItem_do(par1World, par3, par4, par5, new ItemStack(Block.K.bO, 1, par6 & 3));
      } else {
         super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
      }
   }

   @Override
   protected int c(int par1) {
      return par1 & 3;
   }

   @Override
   public boolean a() {
      return !this.a;
   }

   @Override
   public boolean b() {
      return false;
   }

   @Override
   public int a(int par1, int par2) {
      if ((par2 & 3) == 1) {
         return this.bN + 80;
      } else {
         return (par2 & 3) == 3 ? this.bN + 144 : this.bN;
      }
   }

   public void b(boolean par1) {
      this.a = par1;
      this.bN = this.c + (par1 ? 0 : 1);
   }

   @Override
   public void onEntityWalking(World par1World, long par2, int par3, long par4, Entity par5Entity) {
      super.onEntityWalking(par1World, par2, par3, par4, par5Entity);
   }

   @Override
   public int e() {
      return 20;
   }
}
