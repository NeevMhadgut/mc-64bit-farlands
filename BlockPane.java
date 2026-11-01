import java.util.ArrayList;
import java.util.Random;

public class BlockPane extends Block {
   private int a;
   private final boolean b;

   protected BlockPane(int par1, int par2, int par3, acn par4Material, boolean par5) {
      super(par1, par2, par4Material);
      this.a = par3;
      this.b = par5;
   }

   @Override
   public int a(int par1, Random par2Random, int par3) {
      return !this.b ? 0 : super.a(par1, par2Random, par3);
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
      return 18;
   }

   @Override
   public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, long par2, int par3, long par4, int par5) {
      int i = par1IBlockAccess.getBlockId(par2, par3, par4);
      return i == this.bO ? false : super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5);
   }

   @Override
   public void getCollidingBoundingBoxes(World par1World, long par2, int par3, long par4, AxisAlignedBB par5AxisAlignedBB, ArrayList par6ArrayList) {
      boolean flag = this.e(par1World.getBlockId(par2, par3, par4 - 1L));
      boolean flag1 = this.e(par1World.getBlockId(par2, par3, par4 + 1L));
      boolean flag2 = this.e(par1World.getBlockId(par2 - 1L, par3, par4));
      boolean flag3 = this.e(par1World.getBlockId(par2 + 1L, par3, par4));
      if ((!flag2 || !flag3) && (flag2 || flag3 || flag || flag1)) {
         if (flag2 && !flag3) {
            this.a(0.0F, 0.0F, 0.4375F, 0.5F, 1.0F, 0.5625F);
            super.getCollidingBoundingBoxes(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList);
         } else if (!flag2 && flag3) {
            this.a(0.5F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
            super.getCollidingBoundingBoxes(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList);
         }
      } else {
         this.a(0.0F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
         super.getCollidingBoundingBoxes(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList);
      }

      if ((!flag || !flag1) && (flag2 || flag3 || flag || flag1)) {
         if (flag && !flag1) {
            this.a(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 0.5F);
            super.getCollidingBoundingBoxes(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList);
         } else if (!flag && flag1) {
            this.a(0.4375F, 0.0F, 0.5F, 0.5625F, 1.0F, 1.0F);
            super.getCollidingBoundingBoxes(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList);
         }
      } else {
         this.a(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 1.0F);
         super.getCollidingBoundingBoxes(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList);
      }
   }

   @Override
   public void h() {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   @Override
   public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      float f = 0.4375F;
      float f1 = 0.5625F;
      float f2 = 0.4375F;
      float f3 = 0.5625F;
      boolean flag = this.e(par1IBlockAccess.getBlockId(par2, par3, par4 - 1L));
      boolean flag1 = this.e(par1IBlockAccess.getBlockId(par2, par3, par4 + 1L));
      boolean flag2 = this.e(par1IBlockAccess.getBlockId(par2 - 1L, par3, par4));
      boolean flag3 = this.e(par1IBlockAccess.getBlockId(par2 + 1L, par3, par4));
      if ((!flag2 || !flag3) && (flag2 || flag3 || flag || flag1)) {
         if (flag2 && !flag3) {
            f = 0.0F;
         } else if (!flag2 && flag3) {
            f1 = 1.0F;
         }
      } else {
         f = 0.0F;
         f1 = 1.0F;
      }

      if ((!flag || !flag1) && (flag2 || flag3 || flag || flag1)) {
         if (flag && !flag1) {
            f2 = 0.0F;
         } else if (!flag && flag1) {
            f3 = 1.0F;
         }
      } else {
         f2 = 0.0F;
         f3 = 1.0F;
      }

      this.a(f, 0.0F, f2, f1, 1.0F, f3);
   }

   public int v() {
      return this.a;
   }

   public final boolean e(int par1) {
      return Block.n[par1] || par1 == this.bO || par1 == Block.M.bO;
   }
}
