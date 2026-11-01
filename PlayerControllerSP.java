import net.minecraft.client.Minecraft;

public class PlayerControllerSP extends PlayerController {
   private long c = -1L;
   private int d = -1;
   private long e = -1L;
   private float f = 0.0F;
   private float g = 0.0F;
   private float h = 0.0F;
   private int i = 0;

   public PlayerControllerSP(Minecraft par1Minecraft) {
      super(par1Minecraft);
   }

   @Override
   public void a(EntityPlayer par1EntityPlayer) {
      par1EntityPlayer.u = -180.0F;
   }

   @Override
   public boolean d() {
      return true;
   }

   @Override
   public boolean onPlayerDestroyBlock(long par1, int par2, long par3, int par4) {
      int i = this.a.f.getBlockId(par1, par2, par3);
      int j = this.a.f.getBlockMetadata(par1, par2, par3);
      boolean flag = super.onPlayerDestroyBlock(par1, par2, par3, par4);
      ItemStack itemstack = this.a.h.EntityThrowable();
      boolean flag1 = this.a.h.b(Block.m[i]);
      if (itemstack != null) {
         itemstack.onDestroyBlock(i, par1, par2, par3, this.a.h);
         if (itemstack.a == 0) {
            itemstack.a(this.a.h);
            this.a.h.aw();
         }
      }

      if (flag && flag1) {
         Block.m[i].harvestBlock(this.a.f, this.a.h, par1, par2, par3, j);
      }

      return flag;
   }

   @Override
   public void clickBlock(long par1, int par2, long par3, int par4) {
      if (this.a.h.canPlayerEdit(par1, par2, par3)) {
         this.a.f.func_48457_a(this.a.h, par1, par2, par3, par4);
         int i = this.a.f.getBlockId(par1, par2, par3);
         if (i > 0 && this.f == 0.0F) {
            Block.m[i].onBlockClicked(this.a.f, par1, par2, par3, this.a.h);
         }

         if (i > 0 && Block.m[i].a(this.a.h) >= 1.0F) {
            this.onPlayerDestroyBlock(par1, par2, par3, par4);
         }
      }
   }

   @Override
   public void a() {
      this.f = 0.0F;
      this.i = 0;
   }

   @Override
   public void onPlayerDamageBlock(long par1, int par2, long par3, int par4) {
      if (this.i > 0) {
         this.i--;
      } else {
         if (par1 == this.c && par2 == this.d && par3 == this.e) {
            int i = this.a.f.getBlockId(par1, par2, par3);
            if (!this.a.h.canPlayerEdit(par1, par2, par3)) {
               return;
            }

            if (i == 0) {
               return;
            }

            Block block = Block.m[i];
            this.f = this.f + block.a(this.a.h);
            if (this.h % 4.0F == 0.0F && block != null) {
               this.a.C.b(block.cb.d(), (float)par1 + 0.5F, par2 + 0.5F, (float)par3 + 0.5F, (block.cb.b() + 1.0F) / 8.0F, block.cb.c() * 0.5F);
            }

            this.h++;
            if (this.f >= 1.0F) {
               this.onPlayerDestroyBlock(par1, par2, par3, par4);
               this.f = 0.0F;
               this.g = 0.0F;
               this.h = 0.0F;
               this.i = 5;
            }
         } else {
            this.f = 0.0F;
            this.g = 0.0F;
            this.h = 0.0F;
            this.c = par1;
            this.d = par2;
            this.e = par3;
         }
      }
   }

   @Override
   public void a(float par1) {
      if (this.f <= 0.0F) {
         this.a.w.b = 0.0F;
         this.a.g.g = 0.0F;
      } else {
         float f = this.g + (this.f - this.g) * par1;
         this.a.w.b = f;
         this.a.g.g = f;
      }
   }

   @Override
   public float b() {
      return 4.0F;
   }

   @Override
   public void a(World par1World) {
      super.a(par1World);
   }

   @Override
   public EntityPlayer b(World par1World) {
      return super.b(par1World);
   }

   @Override
   public void c() {
      this.g = this.f;
      this.a.C.c();
   }

   @Override
   public boolean onPlayerRightClick(EntityPlayer par1EntityPlayer, World par2World, ItemStack par3ItemStack, long par4, int par5, long par6, int par7) {
      int i = par2World.getBlockId(par4, par5, par6);
      if (i > 0 && Block.m[i].blockActivated(par2World, par4, par5, par6, par1EntityPlayer)) {
         return true;
      } else {
         return par3ItemStack == null ? false : par3ItemStack.useItem(par1EntityPlayer, par2World, par4, par5, par6, par7);
      }
   }

   @Override
   public boolean f() {
      return true;
   }
}
