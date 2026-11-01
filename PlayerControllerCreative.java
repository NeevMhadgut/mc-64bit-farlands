import net.minecraft.client.Minecraft;

public class PlayerControllerCreative extends PlayerController {
   private int c;

   public PlayerControllerCreative(Minecraft par1Minecraft) {
      super(par1Minecraft);
      this.b = true;
   }

   public static void d(EntityPlayer par0EntityPlayer) {
      par0EntityPlayer.aT.c = true;
      par0EntityPlayer.aT.d = true;
      par0EntityPlayer.aT.a = true;
   }

   public static void e(EntityPlayer par0EntityPlayer) {
      par0EntityPlayer.aT.c = false;
      par0EntityPlayer.aT.b = false;
      par0EntityPlayer.aT.d = false;
      par0EntityPlayer.aT.a = false;
   }

   @Override
   public void b(EntityPlayer par1EntityPlayer) {
      d(par1EntityPlayer);

      for (int i = 0; i < 9; i++) {
         if (par1EntityPlayer.ap.a[i] == null) {
            par1EntityPlayer.ap.a[i] = new ItemStack((Block)fc.a.get(i));
         }
      }
   }

   public static void clickBlockCreative(Minecraft par0Minecraft, PlayerController par1PlayerController, long par2, int par3, long par4, int par5) {
      if (!par0Minecraft.f.func_48457_a(par0Minecraft.h, par2, par3, par4, par5)) {
         par1PlayerController.onPlayerDestroyBlock(par2, par3, par4, par5);
      }
   }

   @Override
   public boolean onPlayerRightClick(EntityPlayer par1EntityPlayer, World par2World, ItemStack par3ItemStack, long par4, int par5, long par6, int par7) {
      int i = par2World.getBlockId(par4, par5, par6);
      if (i > 0 && Block.m[i].blockActivated(par2World, par4, par5, par6, par1EntityPlayer)) {
         return true;
      }

      if (par3ItemStack == null) {
         return false;
      }

      int j = par3ItemStack.i();
      int k = par3ItemStack.a;
      boolean flag = par3ItemStack.useItem(par1EntityPlayer, par2World, par4, par5, par6, par7);
      par3ItemStack.b(j);
      par3ItemStack.a = k;
      return flag;
   }

   @Override
   public void clickBlock(long par1, int par2, long par3, int par4) {
      clickBlockCreative(this.a, this, par1, par2, par3, par4);
      this.c = 5;
   }

   @Override
   public void onPlayerDamageBlock(long par1, int par2, long par3, int par4) {
      this.c--;
      if (this.c <= 0) {
         this.c = 5;
         clickBlockCreative(this.a, this, par1, par2, par3, par4);
      }
   }

   @Override
   public void a() {
   }

   @Override
   public boolean d() {
      return false;
   }

   @Override
   public void a(World par1World) {
      super.a(par1World);
   }

   @Override
   public float b() {
      return 5.0F;
   }

   @Override
   public boolean g() {
      return false;
   }

   @Override
   public boolean h() {
      return true;
   }

   @Override
   public boolean i() {
      return true;
   }
}
