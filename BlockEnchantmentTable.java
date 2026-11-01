import java.util.Random;

public class BlockEnchantmentTable extends BlockContainer {
   protected BlockEnchantmentTable(int par1) {
      super(par1, 166, acn.e);
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
      this.f(0);
   }

   @Override
   public boolean b() {
      return false;
   }

   @Override
   public void randomDisplayTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      super.randomDisplayTick(par1World, par2, par3, par4, par5Random);

      for (long i = par2 - 2L; i <= par2 + 2L; i++) {
         for (long j = par4 - 2L; j <= par4 + 2L; j++) {
            if (i > par2 - 2L && i < par2 + 2L && j == par4 - 1L) {
               j = par4 + 2L;
            }

            if (par5Random.nextInt(16) == 0) {
               for (int k = par3; k <= par3 + 1; k++) {
                  if (par1World.getBlockId(i, k, j) == Block.MapGenVillage.bO) {
                     if (!par1World.isAirBlock((i - par2) / 2L + par2, k, (j - par4) / 2L + par4)) {
                        break;
                     }

                     par1World.a(
                        "enchantmenttable",
                        par2 + 0.5,
                        par3 + 2.0,
                        par4 + 0.5,
                        (float)(i - par2) + par5Random.nextFloat() - 0.5,
                        k - par3 - par5Random.nextFloat() - 1.0F,
                        (float)(j - par4) + par5Random.nextFloat() - 0.5
                     );
                  }
               }
            }
         }
      }
   }

   @Override
   public boolean a() {
      return false;
   }

   @Override
   public int a(int par1, int par2) {
      return this.a_(par1);
   }

   @Override
   public int a_(int par1) {
      if (par1 == 0) {
         return this.bN + 17;
      } else {
         return par1 == 1 ? this.bN : this.bN + 16;
      }
   }

   @Override
   public TileEntity u_() {
      return new TileEntityEnchantmentTable();
   }

   @Override
   public boolean blockActivated(World par1World, long par2, int par3, long par4, EntityPlayer par5EntityPlayer) {
      if (par1World.F) {
         return true;
      }

      par5EntityPlayer.displayGUIEnchantment(par2, par3, par4);
      return true;
   }
}
