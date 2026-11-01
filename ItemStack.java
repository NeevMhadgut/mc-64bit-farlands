import java.util.ArrayList;
import java.util.List;

public final class ItemStack {
   public int a = 0;
   public int b;
   public int c;
   public ady d;
   private int e;

   public ItemStack(Block par1Block) {
      this(par1Block, 1);
   }

   public ItemStack(Block par1Block, int par2) {
      this(par1Block.bO, par2, 0);
   }

   public ItemStack(Block par1Block, int par2, int par3) {
      this(par1Block.bO, par2, par3);
   }

   public ItemStack(Item par1Item) {
      this(par1Item.bQ, 1, 0);
   }

   public ItemStack(Item par1Item, int par2) {
      this(par1Item.bQ, par2, 0);
   }

   public ItemStack(Item par1Item, int par2, int par3) {
      this(par1Item.bQ, par2, par3);
   }

   public ItemStack(int par1, int par2, int par3) {
      this.c = par1;
      this.a = par2;
      this.e = par3;
   }

   public static ItemStack a(ady par0NBTTagCompound) {
      ItemStack itemstack = new ItemStack();
      itemstack.c(par0NBTTagCompound);
      return itemstack.a() == null ? null : itemstack;
   }

   private ItemStack() {
   }

   public ItemStack a(int par1) {
      ItemStack itemstack = new ItemStack(this.c, par1, this.e);
      if (this.d != null) {
         itemstack.d = (ady)this.d.b();
      }

      this.a -= par1;
      return itemstack;
   }

   public Item a() {
      return Item.e[this.c];
   }

   public int b() {
      return this.a().g(this);
   }

   public boolean useItem(EntityPlayer par1EntityPlayer, World par2World, long par3, int par4, long par5, int par6) {
      boolean flag = this.a().onItemUse(this, par1EntityPlayer, par2World, par3, par4, par5, par6);
      if (flag) {
         par1EntityPlayer.a(gv.E[this.c], 1);
      }

      return flag;
   }

   public float a(Block par1Block) {
      return this.a().a(this, par1Block);
   }

   public ItemStack a(World par1World, EntityPlayer par2EntityPlayer) {
      return this.a().a(this, par1World, par2EntityPlayer);
   }

   public ItemStack b(World par1World, EntityPlayer par2EntityPlayer) {
      return this.a().b(this, par1World, par2EntityPlayer);
   }

   public ady b(ady par1NBTTagCompound) {
      par1NBTTagCompound.a("id", (short)this.c);
      par1NBTTagCompound.a("Count", (byte)this.a);
      par1NBTTagCompound.a("Damage", (short)this.e);
      if (this.d != null) {
         par1NBTTagCompound.a("tag", this.d);
      }

      return par1NBTTagCompound;
   }

   public void c(ady par1NBTTagCompound) {
      this.c = par1NBTTagCompound.e("id");
      this.a = par1NBTTagCompound.d("Count");
      this.e = par1NBTTagCompound.e("Damage");
      if (par1NBTTagCompound.c("tag")) {
         this.d = par1NBTTagCompound.m("tag");
      }
   }

   public int c() {
      return this.a().f();
   }

   public boolean d() {
      return this.c() > 1 && (!this.e() || !this.g());
   }

   public boolean e() {
      return Item.e[this.c].h() > 0;
   }

   public boolean f() {
      return Item.e[this.c].g();
   }

   public boolean g() {
      return this.e() && this.e > 0;
   }

   public int h() {
      return this.e;
   }

   public int i() {
      return this.e;
   }

   public void b(int par1) {
      this.e = par1;
   }

   public int j() {
      return Item.e[this.c].h();
   }

   public void a(int par1, EntityLiving par2EntityLiving) {
      if (this.e()) {
         if (par1 > 0 && par2EntityLiving instanceof EntityPlayer) {
            EntityPlayer thisPlayer = (EntityPlayer)par2EntityLiving;
            if (thisPlayer.aT.d) {
               return;
            }

            int i = ais.c(thisPlayer.ap);
            if (i > 0 && par2EntityLiving.k.r.nextInt(i + 1) > 0) {
               return;
            }
         }

         this.e += par1;
         if (this.e > this.j()) {
            par2EntityLiving.c(this);
            if (par2EntityLiving instanceof EntityPlayer) {
               ((EntityPlayer)par2EntityLiving).a(gv.F[this.c], 1);
            }

            this.a--;
            if (this.a < 0) {
               this.a = 0;
            }

            this.e = 0;
         }
      }
   }

   public void a(EntityLiving par1EntityLiving, EntityPlayer par2EntityPlayer) {
      boolean flag = Item.e[this.c].a(this, par1EntityLiving, par2EntityPlayer);
      if (flag) {
         par2EntityPlayer.a(gv.E[this.c], 1);
      }
   }

   public void onDestroyBlock(int par1, long par2, int par3, long par4, EntityPlayer par5EntityPlayer) {
      boolean flag = Item.e[this.c].onBlockDestroyed(this, par1, par2, par3, par4, par5EntityPlayer);
      if (flag) {
         par5EntityPlayer.a(gv.E[this.c], 1);
      }
   }

   public int a(Entity par1Entity) {
      return Item.e[this.c].a(par1Entity);
   }

   public boolean b(Block par1Block) {
      return Item.e[this.c].a(par1Block);
   }

   public void a(EntityPlayer entityplayer) {
   }

   public void a(EntityLiving par1EntityLiving) {
      Item.e[this.c].a(this, par1EntityLiving);
   }

   public ItemStack k() {
      ItemStack itemstack = new ItemStack(this.c, this.a, this.e);
      if (this.d != null) {
         itemstack.d = (ady)this.d.b();
         if (!itemstack.d.equals(this.d)) {
            return itemstack;
         }
      }

      return itemstack;
   }

   public static boolean a(ItemStack par0ItemStack, ItemStack par1ItemStack) {
      if (par0ItemStack == null && par1ItemStack == null) {
         return true;
      } else if (par0ItemStack == null || par1ItemStack == null) {
         return false;
      } else {
         return par0ItemStack.d == null && par1ItemStack.d != null ? false : par0ItemStack.d == null || par0ItemStack.d.equals(par1ItemStack.d);
      }
   }

   public static boolean b(ItemStack par0ItemStack, ItemStack par1ItemStack) {
      if (par0ItemStack == null && par1ItemStack == null) {
         return true;
      } else {
         return par0ItemStack != null && par1ItemStack != null ? par0ItemStack.d(par1ItemStack) : false;
      }
   }

   private boolean d(ItemStack par1ItemStack) {
      if (this.a != par1ItemStack.a) {
         return false;
      } else if (this.c != par1ItemStack.c) {
         return false;
      } else if (this.e != par1ItemStack.e) {
         return false;
      } else {
         return this.d == null && par1ItemStack.d != null ? false : this.d == null || this.d.equals(par1ItemStack.d);
      }
   }

   public boolean a(ItemStack par1ItemStack) {
      return this.c == par1ItemStack.c && this.e == par1ItemStack.e;
   }

   public static ItemStack b(ItemStack par0ItemStack) {
      return par0ItemStack != null ? par0ItemStack.k() : null;
   }

   @Override
   public String toString() {
      return this.a + "x" + Item.e[this.c].e() + "@" + this.e;
   }

   public void a(World par1World, Entity par2Entity, int par3, boolean par4) {
      if (this.b > 0) {
         this.b--;
      }

      Item.e[this.c].a(this, par1World, par2Entity, par3, par4);
   }

   public void a(World par1World, EntityPlayer par2EntityPlayer, int par3) {
      par2EntityPlayer.a(gv.D[this.c], par3);
      Item.e[this.c].c(this, par1World, par2EntityPlayer);
   }

   public boolean c(ItemStack par1ItemStack) {
      return this.c == par1ItemStack.c && this.a == par1ItemStack.a && this.e == par1ItemStack.e;
   }

   public int l() {
      return this.a().b(this);
   }

   public aaq m() {
      return this.a().c(this);
   }

   public void b(World par1World, EntityPlayer par2EntityPlayer, int par3) {
      this.a().a(this, par1World, par2EntityPlayer, par3);
   }

   public boolean n() {
      return this.d != null;
   }

   public ady o() {
      return this.d;
   }

   public no p() {
      return this.d == null ? null : (no)this.d.b("ench");
   }

   public void d(ady par1NBTTagCompound) {
      this.d = par1NBTTagCompound;
   }

   public List q() {
      ArrayList arraylist = new ArrayList();
      Item item = Item.e[this.c];
      arraylist.add(item.d(this));
      item.a(this, arraylist);
      if (this.n()) {
         no nbttaglist = this.p();
         if (nbttaglist != null) {
            for (int i = 0; i < nbttaglist.d(); i++) {
               short word0 = ((ady)nbttaglist.a(i)).e("id");
               short word1 = ((ady)nbttaglist.a(i)).e("lvl");
               if (jt.a[word0] != null) {
                  arraylist.add(jt.a[word0].c(word1));
               }
            }
         }
      }

      return arraylist;
   }

   public boolean r() {
      return this.a().e(this);
   }

   public fo s() {
      return this.a().f(this);
   }

   public boolean t() {
      return !this.a().j(this) ? false : !this.u();
   }

   public void a(jt par1Enchantment, int par2) {
      if (this.d == null) {
         this.d(new ady());
      }

      if (!this.d.c("ench")) {
         this.d.a("ench", new no("ench"));
      }

      no nbttaglist = (no)this.d.b("ench");
      ady nbttagcompound = new ady();
      nbttagcompound.a("id", (short)par1Enchantment.w);
      nbttagcompound.a("lvl", (byte)par2);
      nbttaglist.a(nbttagcompound);
   }

   public boolean u() {
      return this.d != null && this.d.c("ench");
   }
}
