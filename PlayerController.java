import net.minecraft.client.Minecraft;

public abstract class PlayerController {
   protected final Minecraft a;
   public boolean b = false;

   public PlayerController(Minecraft par1Minecraft) {
      this.a = par1Minecraft;
   }

   public void a(World world) {
   }

   public abstract void clickBlock(long var1, int var3, long var4, int var6);

   public boolean onPlayerDestroyBlock(long par1, int par2, long par3, int par4) {
      World world = this.a.f;
      Block block = Block.m[world.getBlockId(par1, par2, par3)];
      if (block == null) {
         return false;
      }

      world.playAuxSFX(2001, par1, par2, par3, block.bO + (world.getBlockMetadata(par1, par2, par3) << 12));
      int i = world.getBlockMetadata(par1, par2, par3);
      boolean flag = world.setBlockWithNotify(par1, par2, par3, 0);
      if (flag) {
         block.onBlockDestroyedByPlayer(world, par1, par2, par3, i);
      }

      return flag;
   }

   public abstract void onPlayerDamageBlock(long var1, int var3, long var4, int var6);

   public abstract void a();

   public void a(float f) {
   }

   public abstract float b();

   public boolean a(EntityPlayer par1EntityPlayer, World par2World, ItemStack par3ItemStack) {
      int i = par3ItemStack.a;
      ItemStack itemstack = par3ItemStack.a(par2World, par1EntityPlayer);
      if (itemstack != par3ItemStack || itemstack != null && itemstack.a != i) {
         par1EntityPlayer.ap.a[par1EntityPlayer.ap.c] = itemstack;
         if (itemstack.a == 0) {
            par1EntityPlayer.ap.a[par1EntityPlayer.ap.c] = null;
         }

         return true;
      } else {
         return false;
      }
   }

   public void a(EntityPlayer entityplayer) {
   }

   public void c() {
   }

   public abstract boolean d();

   public void b(EntityPlayer par1EntityPlayer) {
      PlayerControllerCreative.e(par1EntityPlayer);
   }

   public abstract boolean onPlayerRightClick(EntityPlayer var1, World var2, ItemStack var3, long var4, int var6, long var7, int var9);

   public EntityPlayer b(World par1World) {
      return new EntityPlayerSP(this.a, par1World, this.a.k, par1World.t.g);
   }

   public void a(EntityPlayer par1EntityPlayer, Entity par2Entity) {
      par1EntityPlayer.j(par2Entity);
   }

   public void b(EntityPlayer par1EntityPlayer, Entity par2Entity) {
      par1EntityPlayer.k(par2Entity);
   }

   public ItemStack a(int par1, int par2, int par3, boolean par4, EntityPlayer par5EntityPlayer) {
      return par5EntityPlayer.ar.a(par2, par3, par4, par5EntityPlayer);
   }

   public void a(int par1, EntityPlayer par2EntityPlayer) {
      par2EntityPlayer.ar.a(par2EntityPlayer);
      par2EntityPlayer.ar = par2EntityPlayer.aq;
   }

   public void a(int i, int j) {
   }

   public boolean e() {
      return false;
   }

   public void c(EntityPlayer par1EntityPlayer) {
      par1EntityPlayer.NoiseGeneratorPerlin();
   }

   public boolean f() {
      return false;
   }

   public boolean g() {
      return true;
   }

   public boolean h() {
      return false;
   }

   public boolean i() {
      return false;
   }

   public void a(ItemStack itemstack, int i) {
   }

   public void a(ItemStack itemstack) {
   }
}
