import net.minecraft.client.Minecraft;

public class PlayerControllerMP extends PlayerController {
   private long c = -1L;
   private int d = -1;
   private long e = -1L;
   private float f = 0.0F;
   private float g = 0.0F;
   private float h = 0.0F;
   private int i = 0;
   private boolean j = false;
   private boolean k;
   private NetClientHandler l;
   private int m = 0;

   public PlayerControllerMP(Minecraft par1Minecraft, NetClientHandler par2NetClientHandler) {
      super(par1Minecraft);
      this.l = par2NetClientHandler;
   }

   public void a(boolean par1) {
      this.k = par1;
      if (this.k) {
         PlayerControllerCreative.d(this.a.h);
      } else {
         PlayerControllerCreative.e(this.a.h);
      }
   }

   @Override
   public void a(EntityPlayer par1EntityPlayer) {
      par1EntityPlayer.u = -180.0F;
   }

   @Override
   public boolean d() {
      return !this.k;
   }

   @Override
   public boolean onPlayerDestroyBlock(long par1, int par2, long par3, int par4) {
      if (this.k) {
         return super.onPlayerDestroyBlock(par1, par2, par3, par4);
      }

      int i = this.a.f.getBlockId(par1, par2, par3);
      boolean flag = super.onPlayerDestroyBlock(par1, par2, par3, par4);
      ItemStack itemstack = this.a.h.EntityThrowable();
      if (itemstack != null) {
         itemstack.onDestroyBlock(i, par1, par2, par3, this.a.h);
         if (itemstack.a == 0) {
            itemstack.a(this.a.h);
            this.a.h.aw();
         }
      }

      return flag;
   }

   @Override
   public void clickBlock(long par1, int par2, long par3, int par4) {
      if (this.k) {
         this.l.c(new Packet14BlockDig(0, par1, par2, par3, par4));
         PlayerControllerCreative.clickBlockCreative(this.a, this, par1, par2, par3, par4);
         this.i = 5;
      } else if (!this.j || par1 != this.c || par2 != this.d || par3 != this.e) {
         this.l.c(new Packet14BlockDig(0, par1, par2, par3, par4));
         int i = this.a.f.getBlockId(par1, par2, par3);
         if (i > 0 && this.f == 0.0F) {
            Block.m[i].onBlockClicked(this.a.f, par1, par2, par3, this.a.h);
         }

         if (i > 0 && Block.m[i].a(this.a.h) >= 1.0F) {
            this.onPlayerDestroyBlock(par1, par2, par3, par4);
         } else {
            this.j = true;
            this.c = par1;
            this.d = par2;
            this.e = par3;
            this.f = 0.0F;
            this.g = 0.0F;
            this.h = 0.0F;
         }
      }
   }

   @Override
   public void a() {
      this.f = 0.0F;
      this.j = false;
   }

   @Override
   public void onPlayerDamageBlock(long par1, int par2, long par3, int par4) {
      this.j();
      if (this.i > 0) {
         this.i--;
      } else if (this.k) {
         this.i = 5;
         this.l.c(new Packet14BlockDig(0, par1, par2, par3, par4));
         PlayerControllerCreative.clickBlockCreative(this.a, this, par1, par2, par3, par4);
      } else {
         if (par1 == this.c && par2 == this.d && par3 == this.e) {
            int i = this.a.f.getBlockId(par1, par2, par3);
            if (i == 0) {
               this.j = false;
               return;
            }

            Block block = Block.m[i];
            this.f = this.f + block.a(this.a.h);
            if (this.h % 4.0F == 0.0F && block != null) {
               this.a.C.b(block.cb.d(), (float)par1 + 0.5F, par2 + 0.5F, (float)par3 + 0.5F, (block.cb.b() + 1.0F) / 8.0F, block.cb.c() * 0.5F);
            }

            this.h++;
            if (this.f >= 1.0F) {
               this.j = false;
               this.l.c(new Packet14BlockDig(2, par1, par2, par3, par4));
               this.onPlayerDestroyBlock(par1, par2, par3, par4);
               this.f = 0.0F;
               this.g = 0.0F;
               this.h = 0.0F;
               this.i = 5;
            }
         } else {
            this.clickBlock(par1, par2, par3, par4);
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
      return !this.k ? 4.5F : 5.0F;
   }

   @Override
   public void a(World par1World) {
      super.a(par1World);
   }

   @Override
   public void c() {
      this.j();
      this.g = this.f;
      this.a.C.c();
   }

   private void j() {
      int i = this.a.h.ap.c;
      if (i != this.m) {
         this.m = i;
         this.l.c(new zm(this.m));
      }
   }

   @Override
   public boolean onPlayerRightClick(EntityPlayer par1EntityPlayer, World par2World, ItemStack par3ItemStack, long par4, int par5, long par6, int par7) {
      this.j();
      this.l.c(new Packet15Place(par4, par5, par6, par7, par1EntityPlayer.ap.b()));
      int i = par2World.getBlockId(par4, par5, par6);
      if (i > 0 && Block.m[i].blockActivated(par2World, par4, par5, par6, par1EntityPlayer)) {
         return true;
      } else if (par3ItemStack == null) {
         return false;
      } else if (this.k) {
         int j = par3ItemStack.i();
         int k = par3ItemStack.a;
         boolean flag = par3ItemStack.useItem(par1EntityPlayer, par2World, par4, par5, par6, par7);
         par3ItemStack.b(j);
         par3ItemStack.a = k;
         return flag;
      } else {
         return par3ItemStack.useItem(par1EntityPlayer, par2World, par4, par5, par6, par7);
      }
   }

   @Override
   public boolean a(EntityPlayer par1EntityPlayer, World par2World, ItemStack par3ItemStack) {
      this.j();
      this.l.c(new Packet15Place(-1L, -1, -1L, 255, par1EntityPlayer.ap.b()));
      return super.a(par1EntityPlayer, par2World, par3ItemStack);
   }

   @Override
   public EntityPlayer b(World par1World) {
      return new EntityClientPlayerMP(this.a, par1World, this.a.k, this.l);
   }

   @Override
   public void b(EntityPlayer par1EntityPlayer, Entity par2Entity) {
      this.j();
      this.l.c(new a(par1EntityPlayer.f, par2Entity.f, 1));
      par1EntityPlayer.k(par2Entity);
   }

   @Override
   public void a(EntityPlayer par1EntityPlayer, Entity par2Entity) {
      this.j();
      this.l.c(new a(par1EntityPlayer.f, par2Entity.f, 0));
      par1EntityPlayer.j(par2Entity);
   }

   @Override
   public ItemStack a(int par1, int par2, int par3, boolean par4, EntityPlayer par5EntityPlayer) {
      short word0 = par5EntityPlayer.ar.a(par5EntityPlayer.ap);
      ItemStack itemstack = super.a(par1, par2, par3, par4, par5EntityPlayer);
      this.l.c(new agf(par1, par2, par3, par4, itemstack, word0));
      return itemstack;
   }

   @Override
   public void a(int par1, int par2) {
      this.l.c(new lh(par1, par2));
   }

   @Override
   public void a(ItemStack par1ItemStack, int par2) {
      if (this.k) {
         this.l.c(new db(par2, par1ItemStack));
      }
   }

   @Override
   public void a(ItemStack par1ItemStack) {
      if (this.k && par1ItemStack != null) {
         this.l.c(new db(-1, par1ItemStack));
      }
   }

   @Override
   public void a(int par1, EntityPlayer par2EntityPlayer) {
      if (par1 != -9999) {
         ;
      }
   }

   @Override
   public void c(EntityPlayer par1EntityPlayer) {
      this.j();
      this.l.c(new Packet14BlockDig(5, 0L, 0, 0L, 255));
      super.c(par1EntityPlayer);
   }

   @Override
   public boolean f() {
      return true;
   }

   @Override
   public boolean g() {
      return !this.k;
   }

   @Override
   public boolean h() {
      return this.k;
   }

   @Override
   public boolean i() {
      return this.k;
   }
}
