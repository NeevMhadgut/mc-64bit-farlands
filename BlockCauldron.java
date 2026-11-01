import java.util.ArrayList;
import java.util.Random;

public class BlockCauldron extends Block {
   public BlockCauldron(int par1) {
      super(par1, acn.f);
      this.bN = 154;
   }

   @Override
   public int a(int par1, int par2) {
      if (par1 == 1) {
         return 138;
      } else {
         return par1 != 0 ? 154 : 155;
      }
   }

   @Override
   public void getCollidingBoundingBoxes(World par1World, long par2, int par3, long par4, AxisAlignedBB par5AxisAlignedBB, ArrayList par6ArrayList) {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.3125F, 1.0F);
      super.getCollidingBoundingBoxes(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList);
      float f = 0.125F;
      this.a(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
      super.getCollidingBoundingBoxes(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList);
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
      super.getCollidingBoundingBoxes(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList);
      this.a(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      super.getCollidingBoundingBoxes(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList);
      this.a(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
      super.getCollidingBoundingBoxes(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList);
      this.h();
   }

   @Override
   public void h() {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   @Override
   public boolean a() {
      return false;
   }

   @Override
   public int d() {
      return 24;
   }

   @Override
   public boolean b() {
      return false;
   }

   @Override
   public boolean blockActivated(World par1World, long par2, int par3, long par4, EntityPlayer par5EntityPlayer) {
      if (par1World.F) {
         return true;
      }

      ItemStack itemstack = par5EntityPlayer.ap.b();
      if (itemstack == null) {
         return true;
      }

      int i = par1World.getBlockMetadata(par2, par3, par4);
      if (itemstack.c == Item.EntityAIAttackOnCollide.bQ) {
         if (i < 3) {
            if (!par5EntityPlayer.aT.d) {
               par5EntityPlayer.ap.a(par5EntityPlayer.ap.c, new ItemStack(Item.aw));
            }

            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3);
         }

         return true;
      } else {
         if (itemstack.c == Item.EntityFireball.bQ && i > 0) {
            ItemStack itemstack1 = new ItemStack(Item.bs, 1, 0);
            if (!par5EntityPlayer.ap.a(itemstack1)) {
               par1World.a(new EntityItem(par1World, par2 + 0.5, par3 + 1.5, par4 + 0.5, itemstack1));
            }

            itemstack.a--;
            if (itemstack.a <= 0) {
               par5EntityPlayer.ap.a(par5EntityPlayer.ap.c, null);
            }

            par1World.setBlockMetadataWithNotify(par2, par3, par4, i - 1);
         }

         return true;
      }
   }

   @Override
   public int a(int par1, Random par2Random, int par3) {
      return Item.EntityXPOrb.bQ;
   }
}
