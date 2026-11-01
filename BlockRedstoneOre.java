import java.util.Random;

public class BlockRedstoneOre extends Block {
   private boolean a;

   public BlockRedstoneOre(int par1, int par2, boolean par3) {
      super(par1, par2, acn.e);
      if (par3) {
         this.a(true);
      }

      this.a = par3;
   }

   @Override
   public int e() {
      return 30;
   }

   @Override
   public void onBlockClicked(World par1World, long par2, int par3, long par4, EntityPlayer par5EntityPlayer) {
      this.glow(par1World, par2, par3, par4);
      super.onBlockClicked(par1World, par2, par3, par4, par5EntityPlayer);
   }

   @Override
   public void onEntityWalking(World par1World, long par2, int par3, long par4, Entity par5Entity) {
      this.glow(par1World, par2, par3, par4);
      super.onEntityWalking(par1World, par2, par3, par4, par5Entity);
   }

   @Override
   public boolean blockActivated(World par1World, long par2, int par3, long par4, EntityPlayer par5EntityPlayer) {
      this.glow(par1World, par2, par3, par4);
      return super.blockActivated(par1World, par2, par3, par4, par5EntityPlayer);
   }

   private void glow(World par1World, long par2, int par3, long par4) {
      this.sparkle(par1World, par2, par3, par4);
      if (this.bO == Block.aN.bO) {
         par1World.setBlockWithNotify(par2, par3, par4, Block.aO.bO);
      }
   }

   @Override
   public void updateTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      if (this.bO == Block.aO.bO) {
         par1World.setBlockWithNotify(par2, par3, par4, Block.aN.bO);
      }
   }

   @Override
   public int a(int par1, Random par2Random, int par3) {
      return Item.aC.bQ;
   }

   @Override
   public int a(int par1, Random par2Random) {
      return this.a(par2Random) + par2Random.nextInt(par1 + 1);
   }

   @Override
   public int a(Random par1Random) {
      return 4 + par1Random.nextInt(2);
   }

   @Override
   public void randomDisplayTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      if (this.a) {
         this.sparkle(par1World, par2, par3, par4);
      }
   }

   private void sparkle(World par1World, long par2, int par3, long par4) {
      Random random = par1World.r;
      double d = 0.0625;

      for (int i = 0; i < 6; i++) {
         double d1 = par2 + random.nextDouble();
         double d2 = par3 + random.nextDouble();
         double d3 = par4 + random.nextDouble();
         if (i == 0 && !par1World.isBlockOpaqueCube(par2, par3 + 1, par4)) {
            d2 = par3 + 1 + d;
         }

         if (i == 1 && !par1World.isBlockOpaqueCube(par2, par3 - 1, par4)) {
            d2 = par3 + 0 - d;
         }

         if (i == 2 && !par1World.isBlockOpaqueCube(par2, par3, par4 + 1L)) {
            d3 = par4 + 1L + d;
         }

         if (i == 3 && !par1World.isBlockOpaqueCube(par2, par3, par4 - 1L)) {
            d3 = par4 + 0L - d;
         }

         if (i == 4 && !par1World.isBlockOpaqueCube(par2 + 1L, par3, par4)) {
            d1 = par2 + 1L + d;
         }

         if (i == 5 && !par1World.isBlockOpaqueCube(par2 - 1L, par3, par4)) {
            d1 = par2 + 0L - d;
         }

         if (d1 < par2 || d1 > par2 + 1L || d2 < 0.0 || d2 > par3 + 1 || d3 < par4 || d3 > par4 + 1L) {
            par1World.a("reddust", d1, d2, d3, 0.0, 0.0, 0.0);
         }
      }
   }

   @Override
   protected ItemStack b(int par1) {
      return new ItemStack(Block.aN);
   }
}
