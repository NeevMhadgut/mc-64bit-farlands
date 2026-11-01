import java.util.ArrayList;
import java.util.Random;

public class BlockEndPortalFrame extends Block {
   public BlockEndPortalFrame(int par1) {
      super(par1, 159, acn.q);
   }

   @Override
   public int a(int par1, int par2) {
      if (par1 == 1) {
         return this.bN - 1;
      } else {
         return par1 == 0 ? this.bN + 16 : this.bN;
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

   @Override
   public int d() {
      return 26;
   }

   @Override
   public void h() {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
   }

   @Override
   public void getCollidingBoundingBoxes(World par1World, long par2, int par3, long par4, AxisAlignedBB par5AxisAlignedBB, ArrayList par6ArrayList) {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
      super.getCollidingBoundingBoxes(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList);
      int i = par1World.getBlockMetadata(par2, par3, par4);
      if (e(i)) {
         this.a(0.3125F, 0.8125F, 0.3125F, 0.6875F, 1.0F, 0.6875F);
         super.getCollidingBoundingBoxes(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList);
      }

      this.h();
   }

   public static boolean e(int par0) {
      return (par0 & 4) != 0;
   }

   @Override
   public int a(int par1, Random par2Random, int par3) {
      return 0;
   }

   @Override
   public void onBlockPlacedBy(World par1World, long par2, int par3, long par4, EntityLiving par5EntityLiving) {
      int i = ((MathHelper.c(par5EntityLiving.u * 4.0F / 360.0F + 0.5) & 3) + 2) % 4;
      par1World.setBlockMetadataWithNotify(par2, par3, par4, i);
   }
}
