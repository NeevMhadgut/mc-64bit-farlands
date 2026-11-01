import java.util.ArrayList;
import java.util.Random;

public class BlockEndPortal extends BlockContainer {
   public static boolean a = false;

   protected BlockEndPortal(int par1, acn par2Material) {
      super(par1, 0, par2Material);
      this.a(1.0F);
   }

   @Override
   public TileEntity u_() {
      return new bw();
   }

   @Override
   public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      float f = 0.0625F;
      this.a(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
   }

   @Override
   public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, long par2, int par3, long par4, int par5) {
      return par5 != 0 ? false : super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5);
   }

   @Override
   public void getCollidingBoundingBoxes(World world, long i, int j, long k, AxisAlignedBB axisalignedbb, ArrayList arraylist) {
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
   public int a(Random par1Random) {
      return 0;
   }

   @Override
   public void onEntityCollidedWithBlock(World par1World, long par2, int par3, long par4, Entity par5Entity) {
      if (par5Entity.j == null && par5Entity.i == null && par5Entity instanceof EntityPlayer && !par1World.F) {
         ((EntityPlayer)par5Entity).c(1);
      }
   }

   @Override
   public void randomDisplayTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      double d = (double)par2 + par5Random.nextFloat();
      double d1 = par3 + 0.8;
      double d2 = (double)par4 + par5Random.nextFloat();
      double d3 = 0.0;
      double d4 = 0.0;
      double d5 = 0.0;
      par1World.a("smoke", d, d1, d2, d3, d4, d5);
   }

   @Override
   public int d() {
      return -1;
   }

   @Override
   public void onBlockAdded(World par1World, long par2, int par3, long par4) {
      if (!a) {
         if (par1World.t.g != 0) {
            par1World.setBlockWithNotify(par2, par3, par4, 0);
         }
      }
   }
}
